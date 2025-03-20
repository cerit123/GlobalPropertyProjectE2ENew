@US-17
@UI
@Manager
Feature: US-17_ManagerCreatReport test

  Scenario:Gecersiz tarih araligi sectiginde hata mesaji almalidir


    And Manager olarak Raporlar sekmesine gidilir
    And Manager olarak Start date kismina "Start"   veri girilir
    And Manager olarak End date kismina Start date  kisminda once bir tarih"End" girilir
    And Manager olarak Category kismi secilir
    And Manager olarak Advert type kismi secilir
    And Manager olarak Status kismi secilir
    And rapor olustur butonuna tiklanir
    Then Raporlama olmayip hata mesaji gorulmeli
    And Sayfa kapatilir
