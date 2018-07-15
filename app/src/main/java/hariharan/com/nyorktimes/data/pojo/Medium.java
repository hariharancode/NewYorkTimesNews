package hariharan.com.nyorktimes.data.pojo;

/**
 * Created by hariharan on 15/07/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Medium {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private Integer approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetadatum> mediaMetadata = null;
    private String thumbnailURrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Integer approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
        for(MediaMetadatum m: this.mediaMetadata){
            if(m.getFormat().equals("Large")){
                thumbnailURrl = m.getUrl();
            }
        }

        //TODO set function will not be called so thumbnail can be set in getArticle.Just check if this is true.
        //If set function is called set the thumnaul in this method only.

    }

    public String getArticleThumbnailUrl(){
        for(MediaMetadatum m: this.mediaMetadata){
            if(m.getFormat().equals("Large")){
                thumbnailURrl = m.getUrl();
            }
        }

        return thumbnailURrl;
    }

}

