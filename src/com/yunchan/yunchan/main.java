package com.yunchan.yunchan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin implements Listener, CommandExecutor {
	//public class CommandRtp implements Listener, CommandExecutor
	
	
	public static String hour;
	public static String TotalDate;
	public static String TotalTime;
	public Inventory mastermenu = Bukkit.createInventory(null, 27, "*���ּ��� ���� GUI*"); // �������� �޴�
	
	@Override
	public void onEnable() {

		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA + "mujumenu starts/");
		
		this.getServer().getPluginManager().registerEvents(new inven(), this);
		loadConfig();
	} 

	public static void loadConfig() {
		main.getPlugin(main.class).getConfig().options().copyDefaults(true);
		main.getPlugin(main.class).saveConfig();
	}
	
	public static void getdatetime() {
		
		String thisTail;
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
	    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("mm");
	    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("ss");
	    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("yyyy");
	    DateTimeFormatter myFormatObj4 = DateTimeFormatter.ofPattern("MM");
	    DateTimeFormatter myFormatObj5 = DateTimeFormatter.ofPattern("dd");
	    String formattedDate = myDateObj.format(myFormatObj);
	    String formattedDate1 = myDateObj.format(myFormatObj1);
	    String formattedDate2 = myDateObj.format(myFormatObj2);
	    String formattedDate3 = myDateObj.format(myFormatObj3); //�⵵
	    String formattedDate4 = myDateObj.format(myFormatObj4); //��
	    String formattedDate5 = myDateObj.format(myFormatObj5); //��
	   
	    int yay = Integer.parseInt(formattedDate);
	     
	    if(yay >= 13) {
	    	//13�� - 24���� �� 
	    	hour = Integer.toString(yay - 12);
	    	thisTail = "����";
	    }else {
	    	hour = Integer.toString(yay);
	    	thisTail = "����";
	    }
	    
	    
	    
	    TotalTime = thisTail + " " + hour + "�� " + formattedDate1 + "�� " + formattedDate2 + "��";
	    TotalDate = formattedDate3 + "�� " + formattedDate4 + "�� " + formattedDate5 + "��";
	    
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		e.setJoinMessage(ChatColor.YELLOW + e.getPlayer().getDisplayName() + "playerstartingmsg");

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.YELLOW + e.getPlayer().getDisplayName() + "playerquitmsg");
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("menu")) {
			org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(Material.BEACON);
			org.bukkit.inventory.meta.ItemMeta meta = item.getItemMeta();

			meta.setDisplayName("LOBBY");
			item.setItemMeta(meta);

			mastermenu.setItem(0, item);

			org.bukkit.inventory.ItemStack item1 = new org.bukkit.inventory. ItemStack(Material.BLACK_STAINED_GLASS_PANE);

			mastermenu.setItem(10, item1);
			mastermenu.setItem(1, item1);
			mastermenu.setItem(19, item1);

			org.bukkit.inventory.ItemStack item11 = new org.bukkit.inventory.ItemStack(Material.COMPASS);
			org.bukkit.inventory.meta.ItemMeta meta11 = item11.getItemMeta();

			meta11.setDisplayName(ChatColor.YELLOW + "<�ε����> " + ChatColor.WHITE + "���ּ����� ��Ʈ����!");
			meta11.setLore(Arrays.asList(ChatColor.YELLOW + "[���� ����]", ChatColor.AQUA + " #�����ο�# " + ChatColor.WHITE + "1�� ~ 4��", ChatColor.AQUA + " #���ӽð�# " + ChatColor.RED + "������ ���� �ð��� �����ϴ�!", ChatColor.AQUA + " #��������# " + ChatColor.WHITE + "���ּ����� �߰���!"));
			item11.setItemMeta(meta11);

			mastermenu.setItem(12, item11);
			
			org.bukkit.inventory.ItemStack item114 = new org.bukkit.inventory.ItemStack(Material.COMPASS);
			org.bukkit.inventory.meta.ItemMeta meta114 = item114.getItemMeta();

			meta114.setDisplayName(ChatColor.LIGHT_PURPLE + "<��Ƽ����> " + ChatColor.WHITE + "��� ���ٲ���");
			meta114.setLore(Arrays.asList(ChatColor.YELLOW + "[���� ����]", ChatColor.AQUA + " #�����ο�# " + ChatColor.WHITE + "2�� ~ 7��", ChatColor.AQUA + " #���ӽð�# " + ChatColor.BLUE + "7�� 30��(450��)", ChatColor.AQUA + " #��������# " + ChatColor.WHITE + "�ֺ� ������� �����ؼ� ����������", ChatColor.WHITE + " ��Ƴ�������!"));
			item114.setItemMeta(meta114);
			mastermenu.setItem(13, item114);
			
			
			mastermenu.setItem(14, item11);

			Bukkit.getPlayer(sender.getName()).openInventory(mastermenu);
		} 
		return true;

	}
}

