@US-16
@UI
@Admin
  Feature: US-16_AdminCreatReport test
    Scenario:Populer ilanlarin raporunu olusturabilmelidir


      Given Rapor butonuna tiklanir
      And  En Populer ilanlar kisminda miktar kismi secilir
      And Rapor olustur butonuna tiklanir
      Then  Rapor  populer ilanlar raporu basariyla olustugu gosterilir
      And logout butonuna tiklanir
      And Sayfa kapatilir



