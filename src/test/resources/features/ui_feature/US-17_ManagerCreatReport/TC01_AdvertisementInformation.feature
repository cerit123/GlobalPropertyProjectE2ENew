@US-17
@UI
@Manager
Feature:US-17_Manager Creat Report test

  Scenario:Manager İlanların; start date, end date, category, advert type ve status bilgilerine göre rapor oluşturabilmeli
   # Given Manager olarak  Siteye gidilir
   #When Manager olarak giris yapilir
    When raporlar sayfasina gidilir
    And start date kismina "startDate"veri girilir
    And end date kismina "endDate" veri girilir
    And category kismina gecerli veri girilir
    And advert type kismina gecerli veri grilir
    And status kismina gecerli veri girilir
    And rapor olustur butonuna tiklanir
    Then rapor basariyla olustugu gosterilir
    And sayfa kapatilir
