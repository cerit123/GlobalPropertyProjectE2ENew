
@US-11 @UI @Customer
Feature:
 Scenario:Tarih ve saat girerek ilan için randevu isteğinde bulunabilmeli ( pasitive)
   Given  search box ın üzerindeki sale butonuna tıklanır
   And    search box ın altındaki istenilen emlak seçilir
   And    search butonuna tıklanır
   And    gelen ürünlerden bir tanesi üzerine tıklayarak açılır
   And    Schedule a tour bölümünde geçerli geçerli bir tarih seçilir
   And    Schedule a tour bölümünde geçerli geçerli bir saat seçilir
   And    Submit a tour request butonuna basılır
   Then   TourRequest created successfully yazısı görünür


