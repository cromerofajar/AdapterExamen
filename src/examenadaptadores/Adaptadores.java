package examenadaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        player = new FormatAdapter(new DivX());
        player.play("file.divx");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage media;

        public FormatAdapter(MediaPackage m) {
            media = m;
        }
        
        private MediaDivX div;
        
        public FormatAdapter(MediaDivX x){
            div = x;
        }
        
        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            if(filename.endsWith(".divx")){
            div.playFilm(filename);
            }
            else{
            media.playFile(filename);
            }
        }
        
        
        
        
    }
    
}
