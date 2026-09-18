package three;

public class scanario {
    public static void main(String[] args) {
        Item[] items = new Item[4];
        items[0] = new Item();
        items[0].name="삼각김밥";
        items[0].price=1500;
        items[0].stock=10;
        items[0].isEvent=true;
        items[1] = new Item();
        items[1].name="콜라";
        items[1].price=2000;
        items[1].stock=5;
        items[1].isEvent=false;
        items[2] = new Item();
        items[2].name="라면";
        items[2].price=1200;
        items[2].stock=20;
        items[2].isEvent=true;
        items[3] = new Item();
        items[3].name="초코바";
        items[3].price=800;
        items[3].stock=0;
        items[3].isEvent=false;

        Store store=new Store();
        store.name="GS25";
        store.location="서울시 강남구";
        store.isOpen=true;
        store.items=new Item[4];
        for(int i=0;i<4;i++){
            store.items[i]=items[i];
        }


        System.out.println("=====편의점 정보=====");
        System.out.print("편의점명: ");
        System.out.println(store.name);
        System.out.print("위치: ");
        System.out.println(store.location);
        System.out.print("영업 중: ");
        System.out.println(store.isOpen);
        System.out.print("총 상품 수: ");
        System.out.println(store.items.length);
        System.out.println();
        System.out.println("----- 상품 목록-----");
        for(int i=0;i<store.items.length;i++){
            System.out.print(i+1 +". ");
            System.out.println(store.items[i].name);
            System.out.print("   가격: ");
            System.out.println(store.items[i].price+"원");
            System.out.print("   재고: ");
            System.out.println(store.items[i].stock+"개");
            System.out.print("   행사: ");
            System.out.println(store.items[i].isEvent);
        }
    }
}
