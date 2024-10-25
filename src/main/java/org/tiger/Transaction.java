package org.tiger;

class Transaction<A, B, C, D, Cryptos> {
    private final A user;
    private final B side;
    private final C price;
    private final D quantity;
    private final Cryptos tradingPair;

    public Transaction(A user, B side, C price, D quantity, Cryptos tradingPair) {
        this.user = user;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.tradingPair = tradingPair;
    }

    public A getUser() {
        return user;
    }

    public B getSide() {
        return side;
    }

    public C getPrice() {
        return price;
    }

    public D getQuantity() {
        return quantity;
    }

    public Cryptos getTradingPair() {
        return tradingPair;
    }
}