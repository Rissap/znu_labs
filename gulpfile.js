var gulp = require('gulp'),
    jade = require('gulp-jade');
    sass = require('gulp-sass');
    browserSync = require('browser-sync').create();
	 
function style(){
	return gulp.src('./sass/**/*.sass')
	.pipe(sass())	
	.pipe(gulp.dest('./public_html/css'))
	.pipe(browserSync.stream());
}

function template() {
    return gulp.src('./jade/**/*.jade')
        .pipe(jade())
        .pipe(gulp.dest('public_html/html'));
}

function watch() {
	browserSync.init({
		server: {
			baseDir: './'
		}
	});
	gulp.watch('./sass/**/*.sass', style);
	gulp.watch('./sass/**/*.sass').on('change', browserSync.reload);
	
}

exports.style = style;
exports.template = template;
exports.watch = watch;