@US-14 @Manager

  Feature:US-14_Manager Request Appointment Test
    Scenario:manager  saat kismini bos birakarak randevu olusturamamalidir

      Given Anasayfaya  tiklanir.
      When secilen ilan a tiklanir
      And  Schedule a Tour kisminda bir tur tarihi secilir.
      And  Schedule a Tour kismindan  tur saati bos birakilir.
      And  Submit a tour request den butona  tiklanir.
      Then Tour Requestin kismi gonderilmedigi dogrulanir.
