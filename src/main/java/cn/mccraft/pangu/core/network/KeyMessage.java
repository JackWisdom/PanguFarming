package cn.mccraft.pangu.core.network;

import cn.mccraft.pangu.core.PanguCore;
import cn.mccraft.pangu.core.loader.Load;
import cn.mccraft.pangu.core.loader.Proxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple way to send a notice to server
 */
public final class KeyMessage {
    /**
     * prevent new instance
     */
    private KeyMessage(){
    }

    /**
     * add loader to make this class automatically load while needed
     */
    static {
        Proxy.INSTANCE.addLoader(KeyMessage.class);
    }

    @Load(LoaderState.INITIALIZATION)
    public void registerMessageHandler(){
        PanguCore.getNetwork().registerMessage(Handler.class, Context.class, Network.getNextID(), Side.SERVER);
    }

    private static Map<String, Recive> name2Recive = new HashMap();

    public static Recive register(@Nonnull String name, @Nonnull Recive reciver){
        return name2Recive.put(name, reciver);
    }

    static class Handler implements IMessageHandler<Context, Context> {
        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx
         * @return an optional return message
         */
        @Override
        public Context onMessage(Context message, MessageContext ctx) {
            Recive recive = name2Recive.get(message.key);
            if (recive != null) {
                recive.recived(message, ctx);
            } else {
                PanguCore.getLogger().warn("Client is trying to send an unregistered packet");
            }
            return null;
        }
    }

    interface Recive {
        void recived(Context message, MessageContext ctx);
    }

    /**
     * A key message which storage none of information
     */
    static class Context implements IMessage {
        private String key;

        public Context(String key) {
            this.key = key;
        }

        /**
         * Convert from the supplied buffer into your specific message type
         *
         * @param buf
         */
        @Override
        public void fromBytes(ByteBuf buf) {
            int lengh = buf.getInt(0);
            key = buf.getCharSequence(1, lengh, StandardCharsets.UTF_8).toString();
        }

        /**
         * Deconstruct your message into the supplied byte buffer
         *
         * @param buf
         */
        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeInt(key.getBytes(StandardCharsets.UTF_8).length);
            buf.writeCharSequence(key, StandardCharsets.UTF_8);
        }

    }


}