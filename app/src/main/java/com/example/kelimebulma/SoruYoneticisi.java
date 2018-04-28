package com.example.kelimebulma;

import android.content.Context;

import com.example.kelimebulma.model.Soru;

public class SoruYoneticisi {
    public static void sorulariEkle(Context context) {
        AppDatabase.getInstance(context).soruDao().ekle(
                new Soru("Tıbbi Lazımlık", "ördek"),
                new Soru("Sünnet sponsoru", "kirve"),
                new Soru("Futbolun Rus Ruleti", "penaltı"),
                new Soru("Toprak küskünlüğü", "kuraklık"),
                new Soru("Trafik piyadesi", "yaya"),
                new Soru("Erotik köfte", "kadın budu"),
                new Soru("Soğukkanlı beyaz eşya", "buzdolabı"),
                new Soru("Pedagojik gezinti", "atta"),
                new Soru("Asli görevinin yanı sıra", "çakmak"),
                new Soru(" şişe açacağı olarak da kullanılan bir alet", "iş kadını"),
                new Soru("Yüksek ökçeli ticari girişimci", "evde kalmak"),
                new Soru("Bekar hayatında kariyer yapmak", "tavukgöğsü"),
                new Soru("Vejetaryenlerin ancak yalancısının tadına bakabildiği tatlı", "aşk mektubu"),
                new Soru("140 karakterle sınırlı kalmadan sevdayı kelimelere döken iletişim aracı", "kafa izni"),
                new Soru("Ön görülen tarihin ve sürenin haricinde kullanılan beleş tatilMerkezi sinir sisteminin merkezini dış etkilere karşı koruyan muhafaza", "kafatası"),
                new Soru("Sinsi tabiatlı bir patlayıcı", "mayın"),
                new Soru("Can borcu tahsildarı", "Azrail"),
                new Soru("Pişmiş zerzevat harmanı", "korkuluk"),
                new Soru("Kitlesel olarak da yapılabilen cerrahi operasyon", "türlü")
        );
    }
}
