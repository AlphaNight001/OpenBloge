const { defineConfig } = require('@vue/cli-service')
const CompressionPlugin = require('compression-webpack-plugin')
const TerserPlugin = require('terser-webpack-plugin');
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,

  devServer: {
    //通过代理实现跨域
    proxy: {
      '/path': {
        //替换的服务器地址
        target: 'http://localhost:8088',
        ws: true,
        //设置重写的路径
        pathRewrite: {
          '^/path': ''
        }
      }
    },
  },

  configureWebpack:{
    
    
    plugins: [
      new CompressionPlugin({
        test: /\.(.*)$/,
        threshold: 10240 // 只处理比这个值大的资源。按字节计算 设置的是 10kb
      })
    ]
  },

  chainWebpack: config => {
    config.optimization.minimizer('terser').tap(args => {
      args[0].terserOptions.compress.drop_console = true
      return args
    })
  }

})
