@DBUS-04

Feature:  Contacts Tablosu Data Kontrolü
  @DBUS-04TC-01
  Scenario: Contacts sutun isimlerini ve bilgilerini doğrula
    Given Veritabanına bağlanılır.
    When  Contacts sütun tablosu çağrılır
    And   Contacts sütundaki veriler eksiksiz gelmeli


  @DBUS-04TC-02
  Scenario:  Contacts sutun isimlerini ve bilgilerini doğrula
    Given Veritabanına bağlanılır.
    When  Contacts tablosunun id, created_at,email,first_name,last_name,message,status sütunları getirilir.
    And   Contacts tablosundan 2409 , 2413 id numaralı sütunlar çağrılır.
