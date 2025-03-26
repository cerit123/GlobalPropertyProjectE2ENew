@DBUS-07

Feature:  Countries Tablosu Data Kontrolü
  @DBUS-07TC-01
  Scenario: Countries sutun isimlerini ve bilgilerini doğrula
    Given   Veritabanı ile baglantı kurulur
    When    Countries sütun tablosu çağrılır
    And     Countries sütundaki veriler eksiksiz gelmeli

  @DBUS-07TC-02
  Scenario:  Countries sutun isimlerini ve bilgilerini doğrula
    Given    Veritabanı ile baglantı kurulur
    And      Countries tablosundan 230 , 75 id numaralı sütunlar çağrılır.
