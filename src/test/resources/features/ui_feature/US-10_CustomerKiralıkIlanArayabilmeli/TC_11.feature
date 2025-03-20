
@US-10 @Customer
Feature:
 Scenario:Randevu isteği onaylandığında ve reddedildiğinde görebilmeli
   Given  search box ın üzerindeki rent butonuna tıklanır
   And    search box ın altındaki istenilen emlak seçilir
   And    search butonuna tıklanır
   And    gelen ürünlerden bir tanesi üzerine tıklayarak açılır
   And    Schedule a tour bölümünde geçerli geçerli bir tarih seçilir
   And    Schedule a tour bölümünde geçerli geçerli bir saat seçilir
   And    Submit a tour request butonuna basılır
   And    TourRequest created successfully yazısı görünür
   And    sağ üstteki kullanıcı ikonuna tıklanır
   And    açılan dropdown da tur isteklerim butonuna tıklanır
   And    Oluşturulan randevunun eklendiği görülür
   Then   Status sütununda oluşturulan randevunun durumu görülür
