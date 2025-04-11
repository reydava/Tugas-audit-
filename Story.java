/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class Story {
    private Scene startScene;
    private Character player;
    private Scanner scanner;

    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== PETUALANGAN DIMULAI ===");
        System.out.println("Nama karakter: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("XP: " + player.getXP());
        System.out.println("==========================");
        
        play();
    }

    public void play() {
        Scene currentScene = startScene;
        
        while (currentScene != null) {
            // Tampilkan scene saat ini
            currentScene.displayScene();
            
            // Jika scene adalah scene akhir, selesai
            if (currentScene.isEndScene()) {
                break;
            }
            
            // Dapatkan input pemain
            System.out.print("\nPilih tindakan (A/B/C/INFO): ");
            String choice = scanner.nextLine().trim();
            
            // Jika pemain ingin melihat info
            if (choice.equalsIgnoreCase("INFO")) {
                displayPlayerInfo();
                continue;
            }
            
            // Proses pilihan pemain
            Scene nextScene = currentScene.makeChoice(choice, player);
            
            // Jika input tidak valid
            if (nextScene == null && !currentScene.isEndScene()) {
                System.out.println("Pilihan tidak valid. Coba lagi.");
                continue;
            }
            
            // Jika player kehabisan health
            if (player.getHealth() <= 0) {
                System.out.println("\n=== GAME OVER ===");
                System.out.println(player.getName() + " kehabisan nyawa!");
                System.out.println("Total XP yang didapatkan: " + player.getXP());
                break;
            }
            
            // Update current scene
            currentScene = nextScene;
        }
        
        // Tampilkan statistik akhir
        if (player.getHealth() > 0) {
            System.out.println("\n=== PETUALANGAN SELESAI ===");
            System.out.println("Selamat, " + player.getName() + "!");
            System.out.println("Health tersisa: " + player.getHealth());
            System.out.println("Total XP: " + player.getXP());
            System.out.println("Item terakhir: " + player.getItem());
        }
        
        scanner.close();
    }
    
    private void displayPlayerInfo() {
        System.out.println("\n=== INFO KARAKTER ===");
        System.out.println("Nama: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("XP: " + player.getXP());
        System.out.println("Item: " + player.getItem());
        System.out.println("====================");
    }
}