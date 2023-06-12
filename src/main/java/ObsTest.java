import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;

public class ObsTest {
    static public void main(String[] argc)
    {
        try{
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("rtmp://stream_url");
            grabber.setOption("muxdelay", "0.1");
            grabber.start();

            while (true) {
                Frame frame = grabber.grabFrame();
                if (frame == null) {
                    break;
                }

                if (frame.samples != null) {
                    // 这里处理音频数据
                    // 可以使用frame.samples获取音频数据的字节数组
                }
            }

            grabber.stop();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
