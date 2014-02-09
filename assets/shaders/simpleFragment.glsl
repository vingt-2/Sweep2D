precision mediump float;
varying vec2 vTextureCoord;
uniform sampler2D sTexture;

void main()
{
	//gl_FragColor = texture2D(sTexture, vTextureCoord);
	gl_FragColor = vec4(1.0,0.0,0.0,1.0);
}