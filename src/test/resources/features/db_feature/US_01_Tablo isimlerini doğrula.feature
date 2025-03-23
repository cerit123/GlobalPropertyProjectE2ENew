
@US01TC01DB
  Feature: Tablo isimlerini dogrula

    Scenario: TC-01 Tablo isimlerini dogrula
      Given Database bağlantısı sağlanır
      And Beklenen tablo isimleri düzenlenir
      When Tablo isimlerini almak için query gönderilir
      Then Tablo isimleri dogrulanır
