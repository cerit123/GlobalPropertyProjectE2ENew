@US-14 @Manager

  Feature:US-14_Manager Request Appointment Test
    Scenario:Manager randevu alabilmelidir

      Given Anasayfaya  tiklanir.
      When secilen ilan a tiklanir
      And  Schedule a Tour kismindan gecerli bir tur tarihi secilir.
      And  Schedule a Tour kismindan gecerli tur saati secilir.
      And  Submit a tour request den buton'a  tiklanir.
      Then Tour Requestin kisminin gonderildigi dogrulanir.

