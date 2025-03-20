@US21 @UI @E2E @Admin
Feature: Admin search within read and unread messages by giving a date range

  Scenario: Admin Okunan ve okunmayan mesajlar içerisinde tarih aralığı vererek arama yapabilmeli

    Given Contact mesajları sayfasına gidilir
    When Belirli bir kelime ile arama yapilir
    Then Arama sonuclarinin listelendigi dogrulanir
