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
	public Inventory mastermenu = Bukkit.createInventory(null, 27, "*무주서버 전용 GUI*"); // 제윤찬용 메뉴
	
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
	    String formattedDate3 = myDateObj.format(myFormatObj3); //년도
	    String formattedDate4 = myDateObj.format(myFormatObj4); //월
	    String formattedDate5 = myDateObj.format(myFormatObj5); //날
	   
	    int yay = Integer.parseInt(formattedDate);
	     
	    if(yay >= 13) {
	    	//13시 - 24시일 시 
	    	hour = Integer.toString(yay - 12);
	    	thisTail = "오후";
	    }else {
	    	hour = Integer.toString(yay);
	    	thisTail = "오전";
	    }
	    
	    
	    
	    TotalTime = thisTail + " " + hour + "시 " + formattedDate1 + "분 " + formattedDate2 + "초";
	    TotalDate = formattedDate3 + "년 " + formattedDate4 + "월 " + formattedDate5 + "일";
	    
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

			meta11.setDisplayName(ChatColor.YELLOW + "<인디게임> " + ChatColor.WHITE + "무주서버를 터트려라!");
			meta11.setLore(Arrays.asList(ChatColor.YELLOW + "[게임 정보]", ChatColor.AQUA + " #참여인원# " + ChatColor.WHITE + "1인 ~ 4인", ChatColor.AQUA + " #게임시간# " + ChatColor.RED + "정해진 게임 시간이 없습니다!", ChatColor.AQUA + " #게임전략# " + ChatColor.WHITE + "무주서버야 잘가라!"));
			item11.setItemMeta(meta11);

			mastermenu.setItem(12, item11);
			
			org.bukkit.inventory.ItemStack item114 = new org.bukkit.inventory.ItemStack(Material.COMPASS);
			org.bukkit.inventory.meta.ItemMeta meta114 = item114.getItemMeta();

			meta114.setDisplayName(ChatColor.LIGHT_PURPLE + "<파티게임> " + ChatColor.WHITE + "블록 숨바꼭질");
			meta114.setLore(Arrays.asList(ChatColor.YELLOW + "[게임 정보]", ChatColor.AQUA + " #참여인원# " + ChatColor.WHITE + "2인 ~ 7인", ChatColor.AQUA + " #게임시간# " + ChatColor.BLUE + "7분 30초(450초)", ChatColor.AQUA + " #게임전략# " + ChatColor.WHITE + "주변 블록으로 변장해서 마지막까지", ChatColor.WHITE + " 살아남으세요!"));
			item114.setItemMeta(meta114);
			mastermenu.setItem(13, item114);
			
			
			mastermenu.setItem(14, item11);

			Bukkit.getPlayer(sender.getName()).openInventory(mastermenu);
		} 
		return true;

	}
}

