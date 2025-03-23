Feature: Cities sutun isimlerini ve bilgilerini  dogrula

  @US-06TC01DB
  Scenario:TC-01 Cities sutun isimlerini dogrula
    Given Database bağlantısı sağlanır
    When Beklenen sutun isimleri duzenlenir
    And Cities tablosu sutun isimleri icin query gonderilir
    Then Cities sutun isimlerini dogrula


  @US-06TC02DB
  Scenario: TC-02 Cities tablosundaki datalarının doğruluğunu kontrol etme
    Given Database bağlantısı sağlanır
    When Tabloda Adana isimli sehir icin query gonderilir

    Then Adana şehrinin bilgileri aşağıdaki değerlerle eşleşmelidir
      | id   | lat      | lng      | name  | country_id |
      | 4121 | 36.98635 | 35.32528 | Adana | 223        |
    And Database baglantisi kapatilir