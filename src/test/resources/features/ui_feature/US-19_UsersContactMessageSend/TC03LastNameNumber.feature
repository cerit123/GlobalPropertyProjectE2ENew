@US-19 @Costumer

Feature:   Users Contact Message Send
Scenario:   Send Message
           Given Contact sekmesi tiklanir
           And   Acilan pencereye gecerli bir first name girilir
           And   Acilan pencereye gecersiz bir last name  girilir(rakam)
           And   Gecerli bir email adresi girilir
           And   Acilan pencereye gecerli bir mesaj girilir
           And   Send butonuna tiklanir
           Then   Mesajin gonderilmedigi dogrulanir