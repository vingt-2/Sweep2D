attribute vec4 aPosition;
uniform mat4 uMVPMatrix;
attribute vec2 aTextureCoord;
varying vec2 vTextureCoord;

void main() 
{
	gl_Position = uMVPMatrix * aPosition;
    vTextureCoord = aTextureCoord;
}       