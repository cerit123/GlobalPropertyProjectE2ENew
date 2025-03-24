@DBUS-07

Feature:  Countries Tablosu Data Kontrolü
  @DBUS-07TC-01
  Scenario: Countries sutun isimlerini ve bilgilerini doğrula
    Given   Veritabanına bağlanılır
    When    Countries sütun tablosu çağrılır
    And     Countries sütundaki veriler eksiksiz gelmeli
    Then    Database Bağlantısı kapatılır.

  @DBUS-07TC-02
  Scenario:  Countries sutun isimlerini ve bilgilerini doğrula
    Given    Veritabanına bağlanılır.
    When     Countries tablosunun id ,lat,Ing,name sütunları getirilir.
    And      Countries tablosundan 230 , 75 id numaralı sütunlar çağrılır.
    Then     Database bağlantısı kapatılır.