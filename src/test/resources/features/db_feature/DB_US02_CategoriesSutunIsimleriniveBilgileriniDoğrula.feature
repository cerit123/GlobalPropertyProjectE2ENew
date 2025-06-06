@DBUS-02

  Feature: Categories Tablosu Data Kontrolü
    @DBUS-02TC-01
    Scenario: Categories tablosundaki sütun isimlerinin doğruluğunu kontrol etme
      Given veritabanına bağlanılır
      When  Categories tablosunun kontrol edilir
      Then  tablonun sütun isimlerinin expected result ile uyuştuğu görülür
      Then  Database bağlantısı kapatılır

    @DBUS-02TC-02
    Scenario: Categories tablosundaki datalarının doğruluğunu kontrol etme
      Given veritabanına bağlanılır
      When  categories tablosunun id, title, is_active, ve slug sütunları getirilir
      And   id sütünunu uniq, is active sütununun sadece true ve false, slıg sütununun ise title sütunundaki verileri barındırdığı görülür
      Then  Database bağlantısı kapatılır