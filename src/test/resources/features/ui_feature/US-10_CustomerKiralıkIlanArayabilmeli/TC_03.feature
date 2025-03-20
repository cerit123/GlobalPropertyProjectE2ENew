
@US-10 @UI @Customer
Feature:
 Scenario:Price Range min box ına negatif değer girldiğinde hata mesajı vemeli (negative)
   Given  search box ın üzerindeki rent butonuna tıklanır
   And    search butonuna tıklanır
   And    açılan sol pencerede Price Range bölümünde min kutusuna negatif değer yazılır
   And    açılan sol pencerede Price Range bölümünde max kutusu boş bırakılır
   And    Advert Type, Category, Country dropdownlarında all seçeneği seçilmelidir
   And    City ve District  dropdownları boş olmalıdır
   Then   searchh butonuna tıklanır
   Then   uyarı mesajı görülmelidir


