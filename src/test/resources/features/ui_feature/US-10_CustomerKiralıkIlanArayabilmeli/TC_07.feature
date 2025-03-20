
@US-10 @UI @Customer
Feature:
 Scenario:İlanı verenin iletişim bilgilerini görebilmeli
   Given  search box ın üzerindeki rent butonuna tıklanır
   And    search box ın altındaki istenilen emlak seçilir
   And    search butonuna tıklanır
   And    gelen ürünlerden bir tanesi üzerine tıklayarak açılır
   And    contact number kutusundan görünürlüğü açılır
   Then   send mail kutusundan görünürlüğü açılır
   Then   contact number ve mail görünür olur


