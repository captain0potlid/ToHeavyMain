package com.yunchan.yunchan;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class inven implements Listener{

	@EventHandler
    public void onMenuClick(InventoryClickEvent e){
		
		try {
			Player p = (Player) e.getWhoClicked();
			ItemStack it = e.getCurrentItem();
			String itname = it.getItemMeta().getDisplayName();
		
			//if(e.getWhoClicked().getOpenInventory().getTitle()) = "*무주서버 전용 GUI*"
		
			if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("*무주서버 전용 GUI*")) {
				e.setCancelled(true); //일단 이벤트 취소
		
				//코드 그냥 여기에 넣기
		
				if(it.equals(Material.AIR)) return;
				if(!e.getCurrentItem().hasItemMeta()) return;
			
			
				//AIR 제외
			
		
				if(itname.contains("GAME")) { 
					//GAME 관련 메뉴
					
					if(itname.contains("")) {
					
					}
				}
		
				if(itname.contains("LOBBY")) {
			
				}
			} else {
				return;
			}
			
		} catch(Exception x) {
			ConsoleCommandSender consol = Bukkit.getConsoleSender();

			consol.sendMessage(ChatColor.RED+ "[ALERT!] EXCEPTION HAS BEEN CHECKED >>> " + ChatColor.AQUA + x.getCause());
			
			main.getdatetime();
			
			main.getPlugin(main.class).getConfig().set(main.TotalDate + "." + main.TotalTime , Bukkit.getPlayer(e.getWhoClicked().getUniqueId()).getUniqueId() + "[" + Bukkit.getPlayer(e.getWhoClicked().getUniqueId()).getDisplayName() + "] - " + x.getCause());
			
			
			main.getPlugin(main.class).saveConfig();
		}
		
			
	}
}
