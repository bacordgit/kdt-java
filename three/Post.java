package three;

public class Post {
        String title;
        String body;
        Post(){
            setTitle("title");
            setBody("body");
        }
        public String getTitle(){
            return this.title;
        }
        public String getBody(){
            return this.body;
        }
        public void setTitle(String title){
            this.title=title;
        }
        public void setBody(String body){
            this.body=body;
        }
        public String plusTitle(){
            return title+"1";
        }
        public boolean isBody(){
            return body==null;
        }



}
