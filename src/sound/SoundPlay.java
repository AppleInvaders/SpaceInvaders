package sound;

import java.io.IOException;


public class SoundPlay{
    private static SoundPlay instance;
    private int effectVolume = 70;
    private int bgmVolume = 50;
    private SoundBgm sb;

    private SoundPlay(){}
    public static SoundPlay getInstance(){
        if(instance == null) instance = new SoundPlay();
        return instance;
    }

    public void play(SoundType type){
        try{
            switch (type){
                case hit:

                case shoot:

                case enemyKill:

                case menuClick:
                    playEffect("sound/MenuClick_001.wav");
                    break;

                case menuSelect:
                    playEffect("sound/MenuSelect_001.wav");
                    break;
                case mainGameBgm:
                    playBgm("MainScreen_BGM_001.wav");
                    break;
            }
        }
        catch (IOException e1){
            return;
        }

    }

    //SoundPlay.getInstance().Play("파일명.wav"); 로 음악 재생
    //음악은 res폴더안에
    public void playBgm(String filename){
        if(sb == null || !sb.bgmClip.isActive()){
            sb = new SoundBgm(filename);
            sb.play();
        }
    }

    public void stopBgm(){
        sb.stop();   
    }


    public void playEffect(String filename) throws IOException {
        SoundEffect se = new SoundEffect(filename);
        se.setVolume(effectVolume);
        se.play();
        se.stop();
    }

    public void setEffectVolume(int value){
        this.effectVolume = value;
    }

    public void setBgmVolume(int value){
        this.bgmVolume = value;
    }

    public int getEffectVolume(){
        return effectVolume;
    }

    public int getBgmVolume(){
        return bgmVolume;
    }

}