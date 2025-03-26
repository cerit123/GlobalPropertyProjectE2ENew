@US15DB

Feature:  advert_types Tablosu Data Kontrolü

  @US15TC01DB
  Scenario: advert_types sutun isimlerini ve bilgilerini doğrula
    Given Veritabanına bağlanılır.
    When  advert_types sutun tablosu çağrılır
    And   advert_types sutun tablosundaki veriler eksiksiz gelmeli


  @US15TC02DB
  Scenario:  advert_types sutun isimlerini ve bilgilerini doğrula
    Given Veritabanına bağlanılır.
    When  advert_types tablosunun id, built_in, title sütunları getirilir.
    And   advert_types tablosundan 1, 35 id numaralı sütunlar çağrılır.