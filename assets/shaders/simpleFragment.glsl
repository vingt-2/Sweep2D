precision mediump float;
varying vec2 vTextureCoord;
uniform sampler2D sTexture;
uniform float opacity;

void main()
{
	vec4 color = texture2D(sTexture, vTextureCoord);
	color.a *= opacity;
	gl_FragColor = color;
}