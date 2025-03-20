
@US-11 @UI @Customer
Feature:
 Scenario:Price Range max box ına min değerinden küçük  değer girldiğinde hata mesajı vemeli (negative)
   Given  search box ın üzerindeki sale butonuna tıklanır
   And    search butonuna tıklanır
   And    açılan sol pencerede Price Range bölümünde min kutusuna bir değer girilir
   And    açılan sol pencerede Price Range bölümünde max kutusuna miinimum değerden küçük bir değer girilir
   And    Advert Type, Category, Country dropdownlarında all seçeneği seçilmelidir
   And    City ve District  dropdownları boş olmalıdır
   Then   searchh butonuna tıklanır
   Then   uyarı mesajı görülmelidir


