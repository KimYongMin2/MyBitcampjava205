package generic.noGeneric;

public class FruitBox {
    Object item;
    public void store(Object item) { this.item=item; }
    public Object pullOut( ) { return item;}
}
