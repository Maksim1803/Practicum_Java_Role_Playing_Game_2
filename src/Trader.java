
public class Trader implements Seller {
    private String name;
    private int gold = 30; // Пример начальной суммы денег
    private int price = 10;// Стоимость зелья

    public Trader(String торговец, int gold, int price) {
        this.name = торговец;
        this.gold = gold;
        this.price = price;
    }

    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            if (hasEnoughMoney(10)) {
                updateMoney(10);

                if (gold >= 10) {
                    result = "Вы купили зелье за " + price + " золота. У вас осталось " + gold + " золота." +
                            " Желаете продолжить покупки? (да/нет)";
                    increaseGold(10); // Добавляем увеличение денег у торговца после совершения покупки
                } else {
                    result = "Слишком мало денег. Хотите выйти? (да/нет)";
                }
            }
        }
        return result;
    }

    private boolean hasEnoughMoney(int price) {
        return gold >= price;
    }

    public void updateMoney(int price) {
        gold -= price;
    }

    public void increaseGold(int goldAmount) {
        gold += goldAmount;
        System.out.println("Торговец получил " + goldAmount + " золота. Теперь у него " + gold + " золота.");
    }

    public enum Goods {
        POTION
    }
}