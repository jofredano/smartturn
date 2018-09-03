package co.org.smartturn.app.config.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que carga configuracion del servidor embebido (tomcat)
 * 
 * @author joseanor
 *
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring")
public class EmbbedConfiguration {
	
	@Value("${spring.server.port}")
	private Integer serverPort;
	
	@Value("${spring.server.redirectPort}")
	private Integer serverRedirectPort;
	
	@Value("${spring.server.httpConnectionTimeout}")
	private Integer serverConnectionTimeout;
	
	@Value("${spring.server.maximumThreads}")
	private Integer serverMaximumThreads;
	
	@Value("${spring.server.maximumHeaderSize}")
	private Integer serverMaximumHeaderSizes;
	
	@Value("${spring.server.socket.bufferSize}")
	private Integer serverSocketBufferSize;
	
	@Value("${spring.server.socket.rxBufSize}")
	private Integer serverSocketRxBufSize;
	
	@Value("${spring.server.socket.appReadBufSize}")
	private Integer serverSocketAppReadBufSize;
	
	@Value("${spring.server.socket.appWriteBufSize}")
	private Integer serverSocketAppWriteBufSize;

	@Value("${spring.server.contextPath}")
	private String serverContextPath;

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public Integer getServerRedirectPort() {
		return serverRedirectPort;
	}

	public void setServerRedirectPort(Integer serverRedirectPort) {
		this.serverRedirectPort = serverRedirectPort;
	}

	public Integer getServerConnectionTimeout() {
		return serverConnectionTimeout;
	}

	public void setServerConnectionTimeout(Integer serverConnectionTimeout) {
		this.serverConnectionTimeout = serverConnectionTimeout;
	}

	public Integer getServerMaximumThreads() {
		return serverMaximumThreads;
	}

	public void setServerMaximumThreads(Integer serverMaximumThreads) {
		this.serverMaximumThreads = serverMaximumThreads;
	}

	public Integer getServerMaximumHeaderSizes() {
		return serverMaximumHeaderSizes;
	}

	public void setServerMaximumHeaderSizes(Integer serverMaximumHeaderSizes) {
		this.serverMaximumHeaderSizes = serverMaximumHeaderSizes;
	}

	public Integer getServerSocketBufferSize() {
		return serverSocketBufferSize;
	}

	public void setServerSocketBufferSize(Integer serverSocketBufferSize) {
		this.serverSocketBufferSize = serverSocketBufferSize;
	}

	public Integer getServerSocketRxBufSize() {
		return serverSocketRxBufSize;
	}

	public void setServerSocketRxBufSize(Integer serverSocketRxBufSize) {
		this.serverSocketRxBufSize = serverSocketRxBufSize;
	}

	public Integer getServerSocketAppReadBufSize() {
		return serverSocketAppReadBufSize;
	}

	public void setServerSocketAppReadBufSize(Integer serverSocketAppReadBufSize) {
		this.serverSocketAppReadBufSize = serverSocketAppReadBufSize;
	}

	public Integer getServerSocketAppWriteBufSize() {
		return serverSocketAppWriteBufSize;
	}

	public void setServerSocketAppWriteBufSize(Integer serverSocketAppWriteBufSize) {
		this.serverSocketAppWriteBufSize = serverSocketAppWriteBufSize;
	}

	public String getServerContextPath() {
		return serverContextPath;
	}

	public void setServerContextPath(String serverContextPath) {
		this.serverContextPath = serverContextPath;
	}

	@Override
	public String toString() {
		return "EmbbedConfiguration [serverPort=" + serverPort + ", serverRedirectPort=" + serverRedirectPort
				+ ", serverConnectionTimeout=" + serverConnectionTimeout + ", serverMaximumThreads="
				+ serverMaximumThreads + ", serverMaximumHeaderSizes=" + serverMaximumHeaderSizes
				+ ", serverSocketBufferSize=" + serverSocketBufferSize + ", serverSocketRxBufSize="
				+ serverSocketRxBufSize + ", serverSocketAppReadBufSize=" + serverSocketAppReadBufSize
				+ ", serverSocketAppWriteBufSize=" + serverSocketAppWriteBufSize + ", serverContextPath="
				+ serverContextPath + "]";
	}
	
}


