/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input nama karakter
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Petualangan Hutan Terlarang!");
        System.out.print("Masukkan nama karaktermu: ");
        String playerName = scanner.nextLine();
        
        // Buat karakter pemain
        Character player = new Character(playerName, 100);
        
        // Buat scene akhir
        Scene endingGood = new Scene(
            "Selamat! Kamu berhasil menyelesaikan perjalanan di Hutan Terlarang dan menemukan harta karun legendaris. " +
            "Kamu bisa pulang dengan kekayaan dan ketenaran yang selalu kamu impikan!"
        );
        
        Scene endingBad = new Scene(
            "Kamu tersesat di kegelapan Hutan Terlarang dan tidak pernah menemukan jalan keluar. " +
            "Ceritamu berakhir di sini, namun legenda petualanganmu akan tetap hidup..."
        );
        
        Scene endingNeutral = new Scene(
            "Kamu memutuskan untuk keluar dari Hutan Terlarang dengan selamat meskipun tanpa harta karun. " +
            "Setidaknya kamu masih hidup untuk bercerita tentang petualanganmu di hutan misterius ini."
        );
        
        // Buat scene-scene dalam permainan (minimal 10 scene)
        // Scene 10
        Scene scene10 = new Scene(
            "Kamu akhirnya sampai di depan sebuah altar kuno. Di tengahnya, sebuah peti harta karun bersinar. " +
            "Tapi kamu mendengar suara-suara aneh dan merasakan kehadiran sesuatu di sekitarmu.",
            "Buka peti harta dan ambil isinya", endingGood, 0, 50,
            "Hanya mengambil satu item dari peti kemudian pergi", endingNeutral, 0, 30,
            "Pergi tanpa menyentuh peti harta", endingBad, 0, 10
        );
        
        // Scene 9
        Scene scene9 = new Scene(
            "Setelah berjalan beberapa lama, kamu menemukan sebuah jembatan tua yang hampir rusak. " +
            "Di seberang jembatan tampak altar kuno yang menjadi tujuanmu.",
            "Coba lewati jembatan dengan hati-hati", scene10, 10, 20,
            "Cari jalan lain yang lebih aman", scene10, 0, 15,
            "Gunakan tali untuk berayun menyeberangi jurang", scene10, 5, 25
        );
        
        // Scene 8
        Scene scene8 = new Scene(
            "Kamu memasuki sebuah gua gelap. Cahaya obor menerangi dinding-dinding yang dipenuhi ukiran kuno. " +
            "Ada tiga terowongan di hadapanmu.",
            "Masuk ke terowongan kiri yang lebih gelap", scene9, 15, 20,
            "Masuk ke terowongan tengah yang tampak lebih lebar", scene9, 5, 15,
            "Masuk ke terowongan kanan yang ada suara air mengalir", scene9, 10, 25
        );
        
        // Scene 7
        Scene scene7 = new Scene(
            "Kamu menemukan sebuah pondok tua di tengah hutan. Di dalamnya ada seorang pertapa tua.",
            "Bicara dengan pertapa dan minta petunjuk", scene8, 0, 15,
            "Istirahat sejenak di pondok dan pulihkan tenaga", scene8, -10, 10, // Healing (-10 damage)
            "Abaikan pondok dan terus berjalan", scene8, 5, 5
        );
        
        // Scene 6
        Scene scene6 = new Scene(
            "Kamu sampai di tepi sebuah sungai deras. Untuk melanjutkan perjalanan, kamu harus menyeberang.",
            "Coba berenang menyeberangi sungai", scene7, 20, 25,
            "Cari jembatan atau tempat yang lebih dangkal", scene7, 5, 15,
            "Bangun rakit sederhana dari kayu sekitar", scene7, 10, 20
        );
        
        // Scene 5
        Scene scene5 = new Scene(
            "Saat berjalan di hutan, kamu mendengar suara geraman dari semak-semak. " +
            "Tiba-tiba, seekor serigala besar melompat ke hadapanmu!",
            "Melawan serigala dengan senjatamu", scene6, 15, 20,
            "Coba menakut-nakuti serigala dengan api", scene6, 5, 15,
            "Melarikan diri secepat mungkin", scene6, 10, 10
        );
        
        // Scene 4
        Scene scene4 = new Scene(
            "Kamu menemukan persimpangan jalan. Ada tanda penunjuk yang sudah usang, sulit dibaca.",
            "Ambil jalan ke utara yang menuju pegunungan", scene5, 10, 15,
            "Ambil jalan ke timur yang menuju ke jantung hutan", scene5, 15, 20,
            "Ambil jalan setapak kecil yang tampak jarang dilalui", scene5, 5, 10
        );
        
        // Scene 3
        Scene scene3 = new Scene(
            "Kamu menemukan tas ransel usang di dekat pohon. Sepertinya milik petualang sebelumnya.",
            "Periksa isi tas", scene4, 0, 10,
            "Abaikan tas dan lanjutkan perjalanan", scene4, 0, 5,
            "Ambil tas tapi jangan buka dulu", scene4, 0, 7
        );
        
        // Scene 2
        Scene scene2 = new Scene(
            "Malam tiba. Kamu perlu mencari tempat berteduh untuk beristirahat.",
            "Bangun tenda di area terbuka", scene3, 10, 10,
            "Mencari gua untuk berlindung", scene3, 5, 15,
            "Tidur di atas pohon", scene3, 15, 20
        );
        
        // Scene 1 (Scene awal)
        Scene scene1 = new Scene(
            "Kamu berada di pinggir Hutan Terlarang. Di hadapanmu terbentang hutan lebat yang konon menyimpan harta karun legendaris. " +
            "Kamu harus memutuskan dari mana memulai petualanganmu.",
            "Masuk lewat jalan setapak utama", scene2, 0, 5,
            "Cari jalan alternatif yang lebih tersembunyi", scene2, 5, 10,
            "Panjat pohon tinggi dahulu untuk melihat area sekitar", scene2, 10, 15
        );
        
        // Buat objek Story dan mulai permainan
        Story story = new Story(scene1, player);
        story.start();
    }
}