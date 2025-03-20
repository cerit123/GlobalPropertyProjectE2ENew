@US-14 @Manager

  Feature:US-14_Manager Request Appointment Test
    Scenario: manager  tarih girmemeli ve randevu olusturamamalidir

      Given Anasayfaya  tiklanir.
      When secilen ilan a tiklanir
      And  Schedule a Tour kisminda tur tarihi bos birakilir.
      And  Schedule a Tour kismindan gecerli  bir tur saati secilir.
      And  Submit a tour request de buton'a  tiklanir.
      Then Tour Requestin kisminin gonderilmedigi dogrulanir.

