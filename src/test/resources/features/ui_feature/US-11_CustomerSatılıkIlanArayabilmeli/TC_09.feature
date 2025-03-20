
@US-11 @Customer
Feature:
 Scenario: Geçersiz Tarih ve saat girildiğğinde randevu oluşturulamamalı ( negative)
   Given  search box ın üzerindeki sale butonuna tıklanır
   And    search box ın altındaki istenilen emlak seçilir
   And    search butonuna tıklanır
   And    gelen ürünlerden bir tanesi üzerine tıklayarak açılır
   And    Schedule a tour bölümünde tarih kısmı boş bırakılır
   And    Schedule a tour bölümünde saat kısmı boş bırakılır
   Then   Submit a tour request butonuna basılır
   Then   hata mesajları görülmelidir

