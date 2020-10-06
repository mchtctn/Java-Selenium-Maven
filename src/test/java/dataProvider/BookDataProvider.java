package dataProvider;

public class BookDataProvider {

    public static Object[][] createBookSuccessData() {
        Object[][] data = new Object[5][6];
        {
            data[0][0] = "9789752733732";
            data[0][1] = "Hobbit";
            data[0][2] = "J. R. R. Tolkien";
            data[0][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Hobbit’te okurları tüm olayların başlangıcına götürüyor.";
            data[0][4] = "2017";
            data[0][5] = "İthaki Yayınları";
        }
        {
            data[1][0] = "9789752733947";
            data[1][1] = "Silmarillion";
            data[1][2] = "J. R. R. Tolkien";
            data[1][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Silmarillion’da okurları tüm olayların başlangıcına götürüyor.";
            data[1][4] = "2017";
            data[1][5] = "İthaki Yayınları";
        }
        {
            data[2][0] = "9789754700114";
            data[2][1] = "Tutunamayanlar";
            data[2][2] = "Oğuz Atay";
            data[2][3] = "Türk edebiyatının önemli eserlerinden biridir.";
            data[2][4] = "2019";
            data[2][5] = "İletişim Yayınları";
        }
        {
            data[3][0] = "9789754587173";
            data[3][1] = "Devlet";
            data[3][2] = "Platon";
            data[3][3] = "Platon düşlendiği en iyi devleti anlatmıştır.";
            data[3][4] = "2018";
            data[3][5] = "Türkiye İş Bankası Kültür Yayınları";
        }
        {
            data[4][0] = "9789754586985";
            data[4][1] = "Denemeler";
            data[4][2] = "Michel de Montaigne";
            data[4][3] = "Montaigne'nin okurken aldığı notların zamanla denemelere dönüşmesi";
            data[4][4] = "2015";
            data[4][5] = "Türkiye İş Bankası Kültür Yayınları";
        }
        return data;
    }

    public static Object[][] createBookIncorrectData(){
        Object[][] data = new Object[2][6];
        {
            data[0][0] = "9789752733732";
            data[0][1] = "Hobbit";
            data[0][2] = "J. R. R. Tolkien";
            data[0][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Hobbit’te okurları tüm olayların başlangıcına götürüyor.";
            data[0][4] = "ee";
            data[0][5] = "İthaki Yayınları";
        }
        {
            data[1][0] = "9789752733947";
            data[1][1] = "Silmarillion";
            data[1][2] = "J. R. R. Tolkien";
            data[1][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Silmarillion’da okurları tüm olayların başlangıcına götürüyor.";
            data[1][4] = ".-";
            data[1][5] = "İthaki Yayınları";
        }
        return data;
    }

    public static Object[][] editBookSuccessData(){
        Object[][] data = new Object[2][6];
        {
            data[0][0] = "9789752733732";
            data[0][1] = "Hobbit";
            data[0][2] = "J. R. R. Tolkien";
            data[0][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Hobbit’te okurları tüm olayların başlangıcına götürüyor.";
            data[0][4] = "2017";
            data[0][5] = "İthaki Yayınları";
        }
        {
            data[1][0] = "9789752733947";
            data[1][1] = "Silmarillion";
            data[1][2] = "J. R. R. Tolkien";
            data[1][3] = "Kitaplarında hayal gücünün büyük eseri olan Orta Dünya’yı konu alan usta dilbilimci J.R.R Tolkien, Silmarillion’da okurları tüm olayların başlangıcına götürüyor.";
            data[1][4] = "2017";
            data[1][5] = "İthaki Yayınları";
        }
        return data;
    }


}
