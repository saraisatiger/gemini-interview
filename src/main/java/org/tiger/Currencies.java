package org.tiger;

class Currencies {
    public static abstract class Cryptos extends Currencies {
        private final String name;

        public Cryptos(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final Cryptos BTC = new Cryptos("Bitcoin") {};
    public static final Cryptos ETH = new Cryptos("Ethereum") {};
    public static final Cryptos DOGE = new Cryptos("Dogecoin") {};
    public static final Cryptos LTC = new Cryptos("Litecoin") {};
    public static final Cryptos XLM = new Cryptos("StellarLumens") {};

    public static abstract class Fiat extends Currencies {
        private final String name;

        public Fiat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final Fiat USD = new Fiat("U.S. Dollar") {};
    public static final Fiat GBP = new Fiat("British Pound Sterling") {};
}
