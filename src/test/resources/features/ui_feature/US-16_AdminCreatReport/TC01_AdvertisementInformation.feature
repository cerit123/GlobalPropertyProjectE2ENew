@US-16
@UI
@Admin

Feature:US-16_Admin Creat Report test

  Scenario:Admin İlanların; start date, end date, category, advert type ve status bilgilerine göre rapor oluşturabilmeli

    Given Rapor butonuna tiklanir
    And Start date kismina gecerli veri girilir
    And End date kismina gecerli veri girilir
    And Category kismina gecerli veri girilir
    And Advert type kismina gecerli veri grilir
    And Status kismina gecerli veri girilir
    And Rapor olustur butonuna tiklanir
    Then Rapor basariyla olustugu gosterilir
    And logout butonuna tiklanir
    And Sayfa kapatilir







