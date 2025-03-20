
@UI @Customer @US-11
Feature:
 Scenario Outline: Search kısmından istediği emlağı seçip satılık olarak genel arama yapabilmeli
   Given search box ın üzerindeki sale butonuna tıklanır
   And   search box ın altındaki istenilen "<emlakTürü>" seçilir

   And   search butonuna tıklanır
   Then  açılan pencerede seçilen ürünün geldiği görünür
   Then  sayfa kapatilir

   Examples:
     | emlakTürü |
     | HOUSE        |
     | APARTMENT    |
     | OFFICE       |
     | VILLA        |
     | LAND         |
     | SHOP         |

