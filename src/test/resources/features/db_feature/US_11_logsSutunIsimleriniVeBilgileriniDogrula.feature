@US11DB
Feature: logs sutun isimlerini ve bilgilerini doğrula

  @US11TC01DB
  Scenario: TC-01 logs sutun isimlerini dogrula
    Given Database bağlantısı sağlanır
    And Beklenen logs tablosu sütun isimleri düzenlenir
    When logs tablosu sütun isimlerini almak için query gönderilir
    Then logs tablosu sütun isimleri dogrulanır


  @US11TC02DB
  Scenario: TC-02 logs bilgilerini doğrula
    Given Database bağlantısı sağlanır
    And Beklenen logs dataları düzenlenir
    When logs dataları için query gönderilir
    Then logs datası beklenen data ile karşılaştırılır