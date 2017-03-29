// https://github.com/shelljs/shelljs
require('./check-versions')()
require('shelljs/global')
env.NODE_ENV = 'production'

var path = require('path')
var config = require('../config')
var ora = require('ora')
var webpack = require('webpack')
var webpackConfig = require('./webpack.prod.conf')

console.log(
    '  Tip:\n' +
    '  Built files are meant to be served over an HTTP server.\n' +
    '  Opening index.html over file:// won\'t work.\n'
)

var spinner = ora('building for production...')
spinner.start()

var assetsPath = path.join(config.build.assetsRoot, config.build.assetsSubDirectory)
rm('-rf', assetsPath)
mkdir('-p', assetsPath)


webpack(webpackConfig, function (err, stats) {
    spinner.stop()
    if (err) throw err
    process.stdout.write(stats.toString({
            colors: true,
            modules: false,
            children: false,
            chunks: false,
            chunkModules: false
        }) + '\n')
    console.log("----------------------------------------------------------------")
    rm('-rf', '../resources/static')
    rm('-rf', '../resources/templates')
    mkdir("-p", "../templates")
    mkdir("-p", "../resources/static")
    cp('-rf', 'dist/static', '../resources/')
    cp('-rf', 'dist/index.html', '../')
    mkdir('-p', '../resources/static/css/resources/static')
    mv('../resources/static/fonts/', '../resources/static/css/resources/static')
    cp('-rf', 'static/*', '../resources/static/')
    cp('-rf', 'dist/index.html', '../templates/index.ftl')
    rm('-rf', 'dist')
})


