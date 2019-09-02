package creo.com.myapplication;



public class RecyclerPojo {

    public String name;
    public int image;
    public String rat;
    public String distance;

    public RecyclerPojo(String name, int image, String distance, String rat) {
        this.name=name;
        this.image=image;
        this.rat=rat;
        this.distance=distance;
    }

    public String getName() {
        return name;
    }

    public String getRat() {
        return rat;
    }

    public int getImage() {
        return image;
    }

    public String getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRat(String rat) {
        this.rat = rat;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
