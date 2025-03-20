
@US-11 @UI @Customer
Feature:
 Scenario:Ilanı verenin iletişim bilgilerini görebilmeli
   Given  search box ın üzerindeki sale butonuna tıklanır
   And    search box ın altındaki istenilen emlak seçilir
   And    search butonuna tıklanır
   And    gelen ürünlerden bir tanesi üzerine tıklayarak açılır
   And    contact number kutusundan görünürlüğü açılır
   Then   send mail kutusundan görünürlüğü açılır
   Then   contact number ve mail görünür olur


