
package aiss.model.lol.champion;


public class Champion {

    private Integer id;
    private String key;
    private String name;
    private String title;
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

	@Override
	public String toString() {
		return "Champion [id=" + id + ", key=" + key + ", name=" + name + ", title=" + title + ", image=" + image + "]";
	}

}
