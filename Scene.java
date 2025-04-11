/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class Scene {
    private String description;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private Scene nextSceneA;
    private Scene nextSceneB;
    private Scene nextSceneC;
    private int damageA;
    private int damageB;
    private int damageC;
    private int XPA;
    private int XPB;
    private int XPC;
    private boolean isEndScene;

    // Konstruktor untuk scene biasa
    public Scene(String description, String choiceA, Scene nextSceneA, int damageA, int XPA,
                String choiceB, Scene nextSceneB, int damageB, int XPB,
                String choiceC, Scene nextSceneC, int damageC, int XPC) {
        this.description = description;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.nextSceneA = nextSceneA;
        this.nextSceneB = nextSceneB;
        this.nextSceneC = nextSceneC;
        this.damageA = damageA;
        this.damageB = damageB;
        this.damageC = damageC;
        this.XPA = XPA;
        this.XPB = XPB;
        this.XPC = XPC;
        this.isEndScene = false;
    }

    // Konstruktor untuk scene akhir
    public Scene(String description) {
        this.description = description;
        this.isEndScene = true;
    }

    public void displayScene() {
        System.out.println("\n" + description);
        
        if (!isEndScene) {
            System.out.println("\nPilihan:");
            System.out.println("A. " + choiceA);
            System.out.println("B. " + choiceB);
            System.out.println("C. " + choiceC);
            System.out.println("INFO. Lihat status karakter");
        }
    }

    public Scene makeChoice(String choice, Character player) {
        // Handle kasus untuk scene akhir
        if (isEndScene) {
            return null;
        }
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "A":
                player.takeDamage(damageA);
                player.addXP(XPA);
                return nextSceneA;
            case "B":
                player.takeDamage(damageB);
                player.addXP(XPB);
                return nextSceneB;
            case "C":
                player.takeDamage(damageC);
                player.addXP(XPC);
                return nextSceneC;
            default:
                return null;
        }
    }

    // Getter
    public boolean isEndScene() {
        return isEndScene;
    }
}
