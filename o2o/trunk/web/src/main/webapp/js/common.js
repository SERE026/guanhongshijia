/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *  
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty 
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and 
 * confidential information, ideas and expressions.    No part of this 
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior 
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */
(function (A, w) {
    function ma() {
        if (!c.isReady) {
            try {
                s.documentElement.doScroll("left")
            } catch (a) {
                setTimeout(ma, 1);
                return
            }
            c.ready()
        }
    }

    function Qa(a, b) {
        b.src ? c.ajax({
            url: b.src,
            async: false,
            dataType: "script"
        }) : c.globalEval(b.text || b.textContent || b.innerHTML || "");
        b.parentNode && b.parentNode.removeChild(b)
    }

    function X(a, b, d, f, e, j) {
        var i = a.length;
        if (typeof b === "object") {
            for (var o in b)X(a, o, b[o], f, e, d);
            return a
        }
        if (d !== w) {
            f = !j && f && c.isFunction(d);
            for (o = 0; o < i; o++)e(a[o], b, f ? d.call(a[o], o, e(a[o], b)) : d, j);
            return a
        }
        return i ?
            e(a[0], b) : w
    }

    function J() {
        return (new Date).getTime()
    }

    function Y() {
        return false
    }

    function Z() {
        return true
    }

    function na(a, b, d) {
        d[0].type = a;
        return c.event.handle.apply(b, d)
    }

    function oa(a) {
        var b, d = [], f = [], e = arguments, j, i, o, k, n, r;
        i = c.data(this, "events");
        if (!(a.liveFired === this || !i || !i.live || a.button && a.type === "click")) {
            a.liveFired = this;
            var u = i.live.slice(0);
            for (k = 0; k < u.length; k++) {
                i = u[k];
                i.origType.replace(O, "") === a.type ? f.push(i.selector) : u.splice(k--, 1)
            }
            j = c(a.target).closest(f, a.currentTarget);
            n = 0;
            for (r =
                     j.length; n < r; n++)for (k = 0; k < u.length; k++) {
                i = u[k];
                if (j[n].selector === i.selector) {
                    o = j[n].elem;
                    f = null;
                    if (i.preType === "mouseenter" || i.preType === "mouseleave")f = c(a.relatedTarget).closest(i.selector)[0];
                    if (!f || f !== o)d.push({elem: o, handleObj: i})
                }
            }
            n = 0;
            for (r = d.length; n < r; n++) {
                j = d[n];
                a.currentTarget = j.elem;
                a.data = j.handleObj.data;
                a.handleObj = j.handleObj;
                if (j.handleObj.origHandler.apply(j.elem, e) === false) {
                    b = false;
                    break
                }
            }
            return b
        }
    }

    function pa(a, b) {
        return "live." + (a && a !== "*" ? a + "." : "") + b.replace(/\./g, "`").replace(/ /g,
                "&")
    }

    function qa(a) {
        return !a || !a.parentNode || a.parentNode.nodeType === 11
    }

    function ra(a, b) {
        var d = 0;
        b.each(function () {
            if (this.nodeName === (a[d] && a[d].nodeName)) {
                var f = c.data(a[d++]), e = c.data(this, f);
                if (f = f && f.events) {
                    delete e.handle;
                    e.events = {};
                    for (var j in f)for (var i in f[j])c.event.add(this, j, f[j][i], f[j][i].data)
                }
            }
        })
    }

    function sa(a, b, d) {
        var f, e, j;
        b = b && b[0] ? b[0].ownerDocument || b[0] : s;
        if (a.length === 1 && typeof a[0] === "string" && a[0].length < 512 && b === s && !ta.test(a[0]) && (c.support.checkClone || !ua.test(a[0]))) {
            e =
                true;
            if (j = c.fragments[a[0]])if (j !== 1)f = j
        }
        if (!f) {
            f = b.createDocumentFragment();
            c.clean(a, b, f, d)
        }
        if (e)c.fragments[a[0]] = j ? f : 1;
        return {fragment: f, cacheable: e}
    }

    function K(a, b) {
        var d = {};
        c.each(va.concat.apply([], va.slice(0, b)), function () {
            d[this] = a
        });
        return d
    }

    function wa(a) {
        return "scrollTo" in a && a.document ? a : a.nodeType === 9 ? a.defaultView || a.parentWindow : false
    }

    var c = function (a, b) {
            return new c.fn.init(a, b)
        }, Ra = A.jQuery, Sa = A.$, s = A.document, T, Ta = /^[^<]*(<[\w\W]+>)[^>]*$|^#([\w-]+)$/, Ua = /^.[^:#\[\.,]*$/, Va = /\S/,
        Wa = /^(\s|\u00A0)+|(\s|\u00A0)+$/g, Xa = /^<(\w+)\s*\/?>(?:<\/\1>)?$/, P = navigator.userAgent, xa = false, Q = [], L, $ = Object.prototype.toString, aa = Object.prototype.hasOwnProperty, ba = Array.prototype.push, R = Array.prototype.slice, ya = Array.prototype.indexOf;
    c.fn = c.prototype = {
        init: function (a, b) {
            var d, f;
            if (!a)return this;
            if (a.nodeType) {
                this.context = this[0] = a;
                this.length = 1;
                return this
            }
            if (a === "body" && !b) {
                this.context = s;
                this[0] = s.body;
                this.selector = "body";
                this.length = 1;
                return this
            }
            if (typeof a === "string")if ((d = Ta.exec(a)) &&
                (d[1] || !b))if (d[1]) {
                f = b ? b.ownerDocument || b : s;
                if (a = Xa.exec(a))if (c.isPlainObject(b)) {
                    a = [s.createElement(a[1])];
                    c.fn.attr.call(a, b, true)
                } else a = [f.createElement(a[1])]; else {
                    a = sa([d[1]], [f]);
                    a = (a.cacheable ? a.fragment.cloneNode(true) : a.fragment).childNodes
                }
                return c.merge(this, a)
            } else {
                if (b = s.getElementById(d[2])) {
                    if (b.id !== d[2])return T.find(a);
                    this.length = 1;
                    this[0] = b
                }
                this.context = s;
                this.selector = a;
                return this
            } else if (!b && /^\w+$/.test(a)) {
                this.selector = a;
                this.context = s;
                a = s.getElementsByTagName(a);
                return c.merge(this,
                    a)
            } else return !b || b.jquery ? (b || T).find(a) : c(b).find(a); else if (c.isFunction(a))return T.ready(a);
            if (a.selector !== w) {
                this.selector = a.selector;
                this.context = a.context
            }
            return c.makeArray(a, this)
        }, selector: "", jquery: "1.4.2", length: 0, size: function () {
            return this.length
        }, toArray: function () {
            return R.call(this, 0)
        }, get: function (a) {
            return a == null ? this.toArray() : a < 0 ? this.slice(a)[0] : this[a]
        }, pushStack: function (a, b, d) {
            var f = c();
            c.isArray(a) ? ba.apply(f, a) : c.merge(f, a);
            f.prevObject = this;
            f.context = this.context;
            if (b ===
                "find")f.selector = this.selector + (this.selector ? " " : "") + d; else if (b)f.selector = this.selector + "." + b + "(" + d + ")";
            return f
        }, each: function (a, b) {
            return c.each(this, a, b)
        }, ready: function (a) {
            c.bindReady();
            if (c.isReady)a.call(s, c); else Q && Q.push(a);
            return this
        }, eq: function (a) {
            return a === -1 ? this.slice(a) : this.slice(a, +a + 1)
        }, first: function () {
            return this.eq(0)
        }, last: function () {
            return this.eq(-1)
        }, slice: function () {
            return this.pushStack(R.apply(this, arguments), "slice", R.call(arguments).join(","))
        }, map: function (a) {
            return this.pushStack(c.map(this,
                function (b, d) {
                    return a.call(b, d, b)
                }))
        }, end: function () {
            return this.prevObject || c(null)
        }, push: ba, sort: [].sort, splice: [].splice
    };
    c.fn.init.prototype = c.fn;
    c.extend = c.fn.extend = function () {
        var a = arguments[0] || {}, b = 1, d = arguments.length, f = false, e, j, i, o;
        if (typeof a === "boolean") {
            f = a;
            a = arguments[1] || {};
            b = 2
        }
        if (typeof a !== "object" && !c.isFunction(a))a = {};
        if (d === b) {
            a = this;
            --b
        }
        for (; b < d; b++)if ((e = arguments[b]) != null)for (j in e) {
            i = a[j];
            o = e[j];
            if (a !== o)if (f && o && (c.isPlainObject(o) || c.isArray(o))) {
                i = i && (c.isPlainObject(i) ||
                c.isArray(i)) ? i : c.isArray(o) ? [] : {};
                a[j] = c.extend(f, i, o)
            } else if (o !== w)a[j] = o
        }
        return a
    };
    c.extend({
        noConflict: function (a) {
            A.$ = Sa;
            if (a)A.jQuery = Ra;
            return c
        }, isReady: false, ready: function () {
            if (!c.isReady) {
                if (!s.body)return setTimeout(c.ready, 13);
                c.isReady = true;
                if (Q) {
                    for (var a, b = 0; a = Q[b++];)a.call(s, c);
                    Q = null
                }
                c.fn.triggerHandler && c(s).triggerHandler("ready")
            }
        }, bindReady: function () {
            if (!xa) {
                xa = true;
                if (s.readyState === "complete")return c.ready();
                if (s.addEventListener) {
                    s.addEventListener("DOMContentLoaded",
                        L, false);
                    A.addEventListener("load", c.ready, false)
                } else if (s.attachEvent) {
                    s.attachEvent("onreadystatechange", L);
                    A.attachEvent("onload", c.ready);
                    var a = false;
                    try {
                        a = A.frameElement == null
                    } catch (b) {
                    }
                    s.documentElement.doScroll && a && ma()
                }
            }
        }, isFunction: function (a) {
            return $.call(a) === "[object Function]"
        }, isArray: function (a) {
            return $.call(a) === "[object Array]"
        }, isPlainObject: function (a) {
            if (!a || $.call(a) !== "[object Object]" || a.nodeType || a.setInterval)return false;
            if (a.constructor && !aa.call(a, "constructor") && !aa.call(a.constructor.prototype,
                    "isPrototypeOf"))return false;
            var b;
            for (b in a);
            return b === w || aa.call(a, b)
        }, isEmptyObject: function (a) {
            for (var b in a)return false;
            return true
        }, error: function (a) {
            throw a;
        }, parseJSON: function (a) {
            if (typeof a !== "string" || !a)return null;
            a = c.trim(a);
            if (/^[\],:{}\s]*$/.test(a.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "")))return A.JSON && A.JSON.parse ? A.JSON.parse(a) : (new Function("return " +
                a))(); else c.error("Invalid JSON: " + a)
        }, noop: function () {
        }, globalEval: function (a) {
            if (a && Va.test(a)) {
                var b = s.getElementsByTagName("head")[0] || s.documentElement, d = s.createElement("script");
                d.type = "text/javascript";
                if (c.support.scriptEval)d.appendChild(s.createTextNode(a)); else d.text = a;
                b.insertBefore(d, b.firstChild);
                b.removeChild(d)
            }
        }, nodeName: function (a, b) {
            return a.nodeName && a.nodeName.toUpperCase() === b.toUpperCase()
        }, each: function (a, b, d) {
            var f, e = 0, j = a.length, i = j === w || c.isFunction(a);
            if (d)if (i)for (f in a) {
                if (b.apply(a[f],
                        d) === false)break
            } else for (; e < j;) {
                if (b.apply(a[e++], d) === false)break
            } else if (i)for (f in a) {
                if (b.call(a[f], f, a[f]) === false)break
            } else for (d = a[0]; e < j && b.call(d, e, d) !== false; d = a[++e]);
            return a
        }, trim: function (a) {
            return (a || "").replace(Wa, "")
        }, makeArray: function (a, b) {
            b = b || [];
            if (a != null)a.length == null || typeof a === "string" || c.isFunction(a) || typeof a !== "function" && a.setInterval ? ba.call(b, a) : c.merge(b, a);
            return b
        }, inArray: function (a, b) {
            if (b.indexOf)return b.indexOf(a);
            for (var d = 0, f = b.length; d < f; d++)if (b[d] ===
                a)return d;
            return -1
        }, merge: function (a, b) {
            var d = a.length, f = 0;
            if (typeof b.length === "number")for (var e = b.length; f < e; f++)a[d++] = b[f]; else for (; b[f] !== w;)a[d++] = b[f++];
            a.length = d;
            return a
        }, grep: function (a, b, d) {
            for (var f = [], e = 0, j = a.length; e < j; e++)!d !== !b(a[e], e) && f.push(a[e]);
            return f
        }, map: function (a, b, d) {
            for (var f = [], e, j = 0, i = a.length; j < i; j++) {
                e = b(a[j], j, d);
                if (e != null)f[f.length] = e
            }
            return f.concat.apply([], f)
        }, guid: 1, proxy: function (a, b, d) {
            if (arguments.length === 2)if (typeof b === "string") {
                d = a;
                a = d[b];
                b = w
            } else if (b && !c.isFunction(b)) {
                d = b;
                b = w
            }
            if (!b && a)b = function () {
                return a.apply(d || this, arguments)
            };
            if (a)b.guid = a.guid = a.guid || b.guid || c.guid++;
            return b
        }, uaMatch: function (a) {
            a = a.toLowerCase();
            a = /(webkit)[ \/]([\w.]+)/.exec(a) || /(opera)(?:.*version)?[ \/]([\w.]+)/.exec(a) || /(msie) ([\w.]+)/.exec(a) || !/compatible/.test(a) && /(mozilla)(?:.*? rv:([\w.]+))?/.exec(a) || [];
            return {browser: a[1] || "", version: a[2] || "0"}
        }, browser: {}
    });
    P = c.uaMatch(P);
    if (P.browser) {
        c.browser[P.browser] = true;
        c.browser.version = P.version
    }
    if (c.browser.webkit)c.browser.safari =
        true;
    if (ya)c.inArray = function (a, b) {
        return ya.call(b, a)
    };
    T = c(s);
    if (s.addEventListener)L = function () {
        s.removeEventListener("DOMContentLoaded", L, false);
        c.ready()
    }; else if (s.attachEvent)L = function () {
        if (s.readyState === "complete") {
            s.detachEvent("onreadystatechange", L);
            c.ready()
        }
    };
    (function () {
        c.support = {};
        var a = s.documentElement, b = s.createElement("script"), d = s.createElement("div"), f = "script" + J();
        d.style.display = "none";
        d.innerHTML = "   <link/><table></table><a href='/a' style='color:red;float:left;opacity:.55;'>a</a><input type='checkbox'/>";
        var e = d.getElementsByTagName("*"), j = d.getElementsByTagName("a")[0];
        if (!(!e || !e.length || !j)) {
            c.support = {
                leadingWhitespace: d.firstChild.nodeType === 3,
                tbody: !d.getElementsByTagName("tbody").length,
                htmlSerialize: !!d.getElementsByTagName("link").length,
                style: /red/.test(j.getAttribute("style")),
                hrefNormalized: j.getAttribute("href") === "/a",
                opacity: /^0.55$/.test(j.style.opacity),
                cssFloat: !!j.style.cssFloat,
                checkOn: d.getElementsByTagName("input")[0].value === "on",
                optSelected: s.createElement("select").appendChild(s.createElement("option")).selected,
                parentNode: d.removeChild(d.appendChild(s.createElement("div"))).parentNode === null,
                deleteExpando: true,
                checkClone: false,
                scriptEval: false,
                noCloneEvent: true,
                boxModel: null
            };
            b.type = "text/javascript";
            try {
                b.appendChild(s.createTextNode("window." + f + "=1;"))
            } catch (i) {
            }
            a.insertBefore(b, a.firstChild);
            if (A[f]) {
                c.support.scriptEval = true;
                delete A[f]
            }
            try {
                delete b.test
            } catch (o) {
                c.support.deleteExpando = false
            }
            a.removeChild(b);
            if (d.attachEvent && d.fireEvent) {
                d.attachEvent("onclick", function k() {
                    c.support.noCloneEvent =
                        false;
                    d.detachEvent("onclick", k)
                });
                d.cloneNode(true).fireEvent("onclick")
            }
            d = s.createElement("div");
            d.innerHTML = "<input type='radio' name='radiotest' checked='checked'/>";
            a = s.createDocumentFragment();
            a.appendChild(d.firstChild);
            c.support.checkClone = a.cloneNode(true).cloneNode(true).lastChild.checked;
            c(function () {
                var k = s.createElement("div");
                k.style.width = k.style.paddingLeft = "1px";
                s.body.appendChild(k);
                c.boxModel = c.support.boxModel = k.offsetWidth === 2;
                s.body.removeChild(k).style.display = "none"
            });
            a = function (k) {
                var n =
                    s.createElement("div");
                k = "on" + k;
                var r = k in n;
                if (!r) {
                    n.setAttribute(k, "return;");
                    r = typeof n[k] === "function"
                }
                return r
            };
            c.support.submitBubbles = a("submit");
            c.support.changeBubbles = a("change");
            a = b = d = e = j = null
        }
    })();
    c.props = {
        "for": "htmlFor",
        "class": "className",
        readonly: "readOnly",
        maxlength: "maxLength",
        cellspacing: "cellSpacing",
        rowspan: "rowSpan",
        colspan: "colSpan",
        tabindex: "tabIndex",
        usemap: "useMap",
        frameborder: "frameBorder"
    };
    var G = "jQuery" + J(), Ya = 0, za = {};
    c.extend({
        cache: {}, expando: G, noData: {
            embed: true, object: true,
            applet: true
        }, data: function (a, b, d) {
            if (!(a.nodeName && c.noData[a.nodeName.toLowerCase()])) {
                a = a == A ? za : a;
                var f = a[G], e = c.cache;
                if (!f && typeof b === "string" && d === w)return null;
                f || (f = ++Ya);
                if (typeof b === "object") {
                    a[G] = f;
                    e[f] = c.extend(true, {}, b)
                } else if (!e[f]) {
                    a[G] = f;
                    e[f] = {}
                }
                a = e[f];
                if (d !== w)a[b] = d;
                return typeof b === "string" ? a[b] : a
            }
        }, removeData: function (a, b) {
            if (!(a.nodeName && c.noData[a.nodeName.toLowerCase()])) {
                a = a == A ? za : a;
                var d = a[G], f = c.cache, e = f[d];
                if (b) {
                    if (e) {
                        delete e[b];
                        c.isEmptyObject(e) && c.removeData(a)
                    }
                } else {
                    if (c.support.deleteExpando)delete a[c.expando];
                    else a.removeAttribute && a.removeAttribute(c.expando);
                    delete f[d]
                }
            }
        }
    });
    c.fn.extend({
        data: function (a, b) {
            if (typeof a === "undefined" && this.length)return c.data(this[0]); else if (typeof a === "object")return this.each(function () {
                c.data(this, a)
            });
            var d = a.split(".");
            d[1] = d[1] ? "." + d[1] : "";
            if (b === w) {
                var f = this.triggerHandler("getData" + d[1] + "!", [d[0]]);
                if (f === w && this.length)f = c.data(this[0], a);
                return f === w && d[1] ? this.data(d[0]) : f
            } else return this.trigger("setData" + d[1] + "!", [d[0], b]).each(function () {
                c.data(this,
                    a, b)
            })
        }, removeData: function (a) {
            return this.each(function () {
                c.removeData(this, a)
            })
        }
    });
    c.extend({
        queue: function (a, b, d) {
            if (a) {
                b = (b || "fx") + "queue";
                var f = c.data(a, b);
                if (!d)return f || [];
                if (!f || c.isArray(d))f = c.data(a, b, c.makeArray(d)); else f.push(d);
                return f
            }
        }, dequeue: function (a, b) {
            b = b || "fx";
            var d = c.queue(a, b), f = d.shift();
            if (f === "inprogress")f = d.shift();
            if (f) {
                b === "fx" && d.unshift("inprogress");
                f.call(a, function () {
                    c.dequeue(a, b)
                })
            }
        }
    });
    c.fn.extend({
        queue: function (a, b) {
            if (typeof a !== "string") {
                b = a;
                a = "fx"
            }
            if (b ===
                w)return c.queue(this[0], a);
            return this.each(function () {
                var d = c.queue(this, a, b);
                a === "fx" && d[0] !== "inprogress" && c.dequeue(this, a)
            })
        }, dequeue: function (a) {
            return this.each(function () {
                c.dequeue(this, a)
            })
        }, delay: function (a, b) {
            a = c.fx ? c.fx.speeds[a] || a : a;
            b = b || "fx";
            return this.queue(b, function () {
                var d = this;
                setTimeout(function () {
                    c.dequeue(d, b)
                }, a)
            })
        }, clearQueue: function (a) {
            return this.queue(a || "fx", [])
        }
    });
    var Aa = /[\n\t]/g, ca = /\s+/, Za = /\r/g, $a = /href|src|style/, ab = /(button|input)/i, bb = /(button|input|object|select|textarea)/i,
        cb = /^(a|area)$/i, Ba = /radio|checkbox/;
    c.fn.extend({
        attr: function (a, b) {
            return X(this, a, b, true, c.attr)
        }, removeAttr: function (a) {
            return this.each(function () {
                c.attr(this, a, "");
                this.nodeType === 1 && this.removeAttribute(a)
            })
        }, addClass: function (a) {
            if (c.isFunction(a))return this.each(function (n) {
                var r = c(this);
                r.addClass(a.call(this, n, r.attr("class")))
            });
            if (a && typeof a === "string")for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                var e = this[d];
                if (e.nodeType === 1)if (e.className) {
                    for (var j = " " + e.className + " ",
                             i = e.className, o = 0, k = b.length; o < k; o++)if (j.indexOf(" " + b[o] + " ") < 0)i += " " + b[o];
                    e.className = c.trim(i)
                } else e.className = a
            }
            return this
        }, removeClass: function (a) {
            if (c.isFunction(a))return this.each(function (k) {
                var n = c(this);
                n.removeClass(a.call(this, k, n.attr("class")))
            });
            if (a && typeof a === "string" || a === w)for (var b = (a || "").split(ca), d = 0, f = this.length; d < f; d++) {
                var e = this[d];
                if (e.nodeType === 1 && e.className)if (a) {
                    for (var j = (" " + e.className + " ").replace(Aa, " "), i = 0, o = b.length; i < o; i++)j = j.replace(" " + b[i] + " ",
                        " ");
                    e.className = c.trim(j)
                } else e.className = ""
            }
            return this
        }, toggleClass: function (a, b) {
            var d = typeof a, f = typeof b === "boolean";
            if (c.isFunction(a))return this.each(function (e) {
                var j = c(this);
                j.toggleClass(a.call(this, e, j.attr("class"), b), b)
            });
            return this.each(function () {
                if (d === "string")for (var e, j = 0, i = c(this), o = b, k = a.split(ca); e = k[j++];) {
                    o = f ? o : !i.hasClass(e);
                    i[o ? "addClass" : "removeClass"](e)
                } else if (d === "undefined" || d === "boolean") {
                    this.className && c.data(this, "__className__", this.className);
                    this.className =
                        this.className || a === false ? "" : c.data(this, "__className__") || ""
                }
            })
        }, hasClass: function (a) {
            a = " " + a + " ";
            for (var b = 0, d = this.length; b < d; b++)if ((" " + this[b].className + " ").replace(Aa, " ").indexOf(a) > -1)return true;
            return false
        }, val: function (a) {
            if (a === w) {
                var b = this[0];
                if (b) {
                    if (c.nodeName(b, "option"))return (b.attributes.value || {}).specified ? b.value : b.text;
                    if (c.nodeName(b, "select")) {
                        var d = b.selectedIndex, f = [], e = b.options;
                        b = b.type === "select-one";
                        if (d < 0)return null;
                        var j = b ? d : 0;
                        for (d = b ? d + 1 : e.length; j < d; j++) {
                            var i =
                                e[j];
                            if (i.selected) {
                                a = c(i).val();
                                if (b)return a;
                                f.push(a)
                            }
                        }
                        return f
                    }
                    if (Ba.test(b.type) && !c.support.checkOn)return b.getAttribute("value") === null ? "on" : b.value;
                    return (b.value || "").replace(Za, "")
                }
                return w
            }
            var o = c.isFunction(a);
            return this.each(function (k) {
                var n = c(this), r = a;
                if (this.nodeType === 1) {
                    if (o)r = a.call(this, k, n.val());
                    if (typeof r === "number")r += "";
                    if (c.isArray(r) && Ba.test(this.type))this.checked = c.inArray(n.val(), r) >= 0; else if (c.nodeName(this, "select")) {
                        var u = c.makeArray(r);
                        c("option", this).each(function () {
                            this.selected =
                                c.inArray(c(this).val(), u) >= 0
                        });
                        if (!u.length)this.selectedIndex = -1
                    } else this.value = r
                }
            })
        }
    });
    c.extend({
        attrFn: {val: true, css: true, html: true, text: true, data: true, width: true, height: true, offset: true},
        attr: function (a, b, d, f) {
            if (!a || a.nodeType === 3 || a.nodeType === 8)return w;
            if (f && b in c.attrFn)return c(a)[b](d);
            f = a.nodeType !== 1 || !c.isXMLDoc(a);
            var e = d !== w;
            b = f && c.props[b] || b;
            if (a.nodeType === 1) {
                var j = $a.test(b);
                if (b in a && f && !j) {
                    if (e) {
                        b === "type" && ab.test(a.nodeName) && a.parentNode && c.error("type property can't be changed");
                        a[b] = d
                    }
                    if (c.nodeName(a, "form") && a.getAttributeNode(b))return a.getAttributeNode(b).nodeValue;
                    if (b === "tabIndex")return (b = a.getAttributeNode("tabIndex")) && b.specified ? b.value : bb.test(a.nodeName) || cb.test(a.nodeName) && a.href ? 0 : w;
                    return a[b]
                }
                if (!c.support.style && f && b === "style") {
                    if (e)a.style.cssText = "" + d;
                    return a.style.cssText
                }
                e && a.setAttribute(b, "" + d);
                a = !c.support.hrefNormalized && f && j ? a.getAttribute(b, 2) : a.getAttribute(b);
                return a === null ? w : a
            }
            return c.style(a, b, d)
        }
    });
    var O = /\.(.*)$/, db = function (a) {
        return a.replace(/[^\w\s\.\|`]/g,
            function (b) {
                return "\\" + b
            })
    };
    c.event = {
        add: function (a, b, d, f) {
            if (!(a.nodeType === 3 || a.nodeType === 8)) {
                if (a.setInterval && a !== A && !a.frameElement)a = A;
                var e, j;
                if (d.handler) {
                    e = d;
                    d = e.handler
                }
                if (!d.guid)d.guid = c.guid++;
                if (j = c.data(a)) {
                    var i = j.events = j.events || {}, o = j.handle;
                    if (!o)j.handle = o = function () {
                        return typeof c !== "undefined" && !c.event.triggered ? c.event.handle.apply(o.elem, arguments) : w
                    };
                    o.elem = a;
                    b = b.split(" ");
                    for (var k, n = 0, r; k = b[n++];) {
                        j = e ? c.extend({}, e) : {handler: d, data: f};
                        if (k.indexOf(".") > -1) {
                            r = k.split(".");
                            k = r.shift();
                            j.namespace = r.slice(0).sort().join(".")
                        } else {
                            r = [];
                            j.namespace = ""
                        }
                        j.type = k;
                        j.guid = d.guid;
                        var u = i[k], z = c.event.special[k] || {};
                        if (!u) {
                            u = i[k] = [];
                            if (!z.setup || z.setup.call(a, f, r, o) === false)if (a.addEventListener)a.addEventListener(k, o, false); else a.attachEvent && a.attachEvent("on" + k, o)
                        }
                        if (z.add) {
                            z.add.call(a, j);
                            if (!j.handler.guid)j.handler.guid = d.guid
                        }
                        u.push(j);
                        c.event.global[k] = true
                    }
                    a = null
                }
            }
        },
        global: {},
        remove: function (a, b, d, f) {
            if (!(a.nodeType === 3 || a.nodeType === 8)) {
                var e, j = 0, i, o, k, n, r, u, z = c.data(a),
                    C = z && z.events;
                if (z && C) {
                    if (b && b.type) {
                        d = b.handler;
                        b = b.type
                    }
                    if (!b || typeof b === "string" && b.charAt(0) === ".") {
                        b = b || "";
                        for (e in C)c.event.remove(a, e + b)
                    } else {
                        for (b = b.split(" "); e = b[j++];) {
                            n = e;
                            i = e.indexOf(".") < 0;
                            o = [];
                            if (!i) {
                                o = e.split(".");
                                e = o.shift();
                                k = new RegExp("(^|\\.)" + c.map(o.slice(0).sort(), db).join("\\.(?:.*\\.)?") + "(\\.|$)")
                            }
                            if (r = C[e])if (d) {
                                n = c.event.special[e] || {};
                                for (B = f || 0; B < r.length; B++) {
                                    u = r[B];
                                    if (d.guid === u.guid) {
                                        if (i || k.test(u.namespace)) {
                                            f == null && r.splice(B--, 1);
                                            n.remove && n.remove.call(a, u)
                                        }
                                        if (f !=
                                            null)break
                                    }
                                }
                                if (r.length === 0 || f != null && r.length === 1) {
                                    if (!n.teardown || n.teardown.call(a, o) === false)Ca(a, e, z.handle);
                                    delete C[e]
                                }
                            } else for (var B = 0; B < r.length; B++) {
                                u = r[B];
                                if (i || k.test(u.namespace)) {
                                    c.event.remove(a, n, u.handler, B);
                                    r.splice(B--, 1)
                                }
                            }
                        }
                        if (c.isEmptyObject(C)) {
                            if (b = z.handle)b.elem = null;
                            delete z.events;
                            delete z.handle;
                            c.isEmptyObject(z) && c.removeData(a)
                        }
                    }
                }
            }
        },
        trigger: function (a, b, d, f) {
            var e = a.type || a;
            if (!f) {
                a = typeof a === "object" ? a[G] ? a : c.extend(c.Event(e), a) : c.Event(e);
                if (e.indexOf("!") >= 0) {
                    a.type =
                        e = e.slice(0, -1);
                    a.exclusive = true
                }
                if (!d) {
                    a.stopPropagation();
                    c.event.global[e] && c.each(c.cache, function () {
                        this.events && this.events[e] && c.event.trigger(a, b, this.handle.elem)
                    })
                }
                if (!d || d.nodeType === 3 || d.nodeType === 8)return w;
                a.result = w;
                a.target = d;
                b = c.makeArray(b);
                b.unshift(a)
            }
            a.currentTarget = d;
            (f = c.data(d, "handle")) && f.apply(d, b);
            f = d.parentNode || d.ownerDocument;
            try {
                if (!(d && d.nodeName && c.noData[d.nodeName.toLowerCase()]))if (d["on" + e] && d["on" + e].apply(d, b) === false)a.result = false
            } catch (j) {
            }
            if (!a.isPropagationStopped() &&
                f)c.event.trigger(a, b, f, true); else if (!a.isDefaultPrevented()) {
                f = a.target;
                var i, o = c.nodeName(f, "a") && e === "click", k = c.event.special[e] || {};
                if ((!k._default || k._default.call(d, a) === false) && !o && !(f && f.nodeName && c.noData[f.nodeName.toLowerCase()])) {
                    try {
                        if (f[e]) {
                            if (i = f["on" + e])f["on" + e] = null;
                            c.event.triggered = true;
                            f[e]()
                        }
                    } catch (n) {
                    }
                    if (i)f["on" + e] = i;
                    c.event.triggered = false
                }
            }
        },
        handle: function (a) {
            var b, d, f, e;
            a = arguments[0] = c.event.fix(a || A.event);
            a.currentTarget = this;
            b = a.type.indexOf(".") < 0 && !a.exclusive;
            if (!b) {
                d = a.type.split(".");
                a.type = d.shift();
                f = new RegExp("(^|\\.)" + d.slice(0).sort().join("\\.(?:.*\\.)?") + "(\\.|$)")
            }
            e = c.data(this, "events");
            d = e[a.type];
            if (e && d) {
                d = d.slice(0);
                e = 0;
                for (var j = d.length; e < j; e++) {
                    var i = d[e];
                    if (b || f.test(i.namespace)) {
                        a.handler = i.handler;
                        a.data = i.data;
                        a.handleObj = i;
                        i = i.handler.apply(this, arguments);
                        if (i !== w) {
                            a.result = i;
                            if (i === false) {
                                a.preventDefault();
                                a.stopPropagation()
                            }
                        }
                        if (a.isImmediatePropagationStopped())break
                    }
                }
            }
            return a.result
        },
        props: "altKey attrChange attrName bubbles button cancelable charCode clientX clientY ctrlKey currentTarget data detail eventPhase fromElement handler keyCode layerX layerY metaKey newValue offsetX offsetY originalTarget pageX pageY prevValue relatedNode relatedTarget screenX screenY shiftKey srcElement target toElement view wheelDelta which".split(" "),
        fix: function (a) {
            if (a[G])return a;
            var b = a;
            a = c.Event(b);
            for (var d = this.props.length, f; d;) {
                f = this.props[--d];
                a[f] = b[f]
            }
            if (!a.target)a.target = a.srcElement || s;
            if (a.target.nodeType === 3)a.target = a.target.parentNode;
            if (!a.relatedTarget && a.fromElement)a.relatedTarget = a.fromElement === a.target ? a.toElement : a.fromElement;
            if (a.pageX == null && a.clientX != null) {
                b = s.documentElement;
                d = s.body;
                a.pageX = a.clientX + (b && b.scrollLeft || d && d.scrollLeft || 0) - (b && b.clientLeft || d && d.clientLeft || 0);
                a.pageY = a.clientY + (b && b.scrollTop ||
                    d && d.scrollTop || 0) - (b && b.clientTop || d && d.clientTop || 0)
            }
            if (!a.which && (a.charCode || a.charCode === 0 ? a.charCode : a.keyCode))a.which = a.charCode || a.keyCode;
            if (!a.metaKey && a.ctrlKey)a.metaKey = a.ctrlKey;
            if (!a.which && a.button !== w)a.which = a.button & 1 ? 1 : a.button & 2 ? 3 : a.button & 4 ? 2 : 0;
            return a
        },
        guid: 1E8,
        proxy: c.proxy,
        special: {
            ready: {setup: c.bindReady, teardown: c.noop}, live: {
                add: function (a) {
                    c.event.add(this, a.origType, c.extend({}, a, {handler: oa}))
                }, remove: function (a) {
                    var b = true, d = a.origType.replace(O, "");
                    c.each(c.data(this,
                            "events").live || [], function () {
                        if (d === this.origType.replace(O, ""))return b = false
                    });
                    b && c.event.remove(this, a.origType, oa)
                }
            }, beforeunload: {
                setup: function (a, b, d) {
                    if (this.setInterval)this.onbeforeunload = d;
                    return false
                }, teardown: function (a, b) {
                    if (this.onbeforeunload === b)this.onbeforeunload = null
                }
            }
        }
    };
    var Ca = s.removeEventListener ? function (a, b, d) {
        a.removeEventListener(b, d, false)
    } : function (a, b, d) {
        a.detachEvent("on" + b, d)
    };
    c.Event = function (a) {
        if (!this.preventDefault)return new c.Event(a);
        if (a && a.type) {
            this.originalEvent =
                a;
            this.type = a.type
        } else this.type = a;
        this.timeStamp = J();
        this[G] = true
    };
    c.Event.prototype = {
        preventDefault: function () {
            this.isDefaultPrevented = Z;
            var a = this.originalEvent;
            if (a) {
                a.preventDefault && a.preventDefault();
                a.returnValue = false
            }
        }, stopPropagation: function () {
            this.isPropagationStopped = Z;
            var a = this.originalEvent;
            if (a) {
                a.stopPropagation && a.stopPropagation();
                a.cancelBubble = true
            }
        }, stopImmediatePropagation: function () {
            this.isImmediatePropagationStopped = Z;
            this.stopPropagation()
        }, isDefaultPrevented: Y, isPropagationStopped: Y,
        isImmediatePropagationStopped: Y
    };
    var Da = function (a) {
        var b = a.relatedTarget;
        try {
            for (; b && b !== this;)b = b.parentNode;
            if (b !== this) {
                a.type = a.data;
                c.event.handle.apply(this, arguments)
            }
        } catch (d) {
        }
    }, Ea = function (a) {
        a.type = a.data;
        c.event.handle.apply(this, arguments)
    };
    c.each({mouseenter: "mouseover", mouseleave: "mouseout"}, function (a, b) {
        c.event.special[a] = {
            setup: function (d) {
                c.event.add(this, b, d && d.selector ? Ea : Da, a)
            }, teardown: function (d) {
                c.event.remove(this, b, d && d.selector ? Ea : Da)
            }
        }
    });
    if (!c.support.submitBubbles)c.event.special.submit =
    {
        setup: function () {
            if (this.nodeName.toLowerCase() !== "form") {
                c.event.add(this, "click.specialSubmit", function (a) {
                    var b = a.target, d = b.type;
                    if ((d === "submit" || d === "image") && c(b).closest("form").length)return na("submit", this, arguments)
                });
                c.event.add(this, "keypress.specialSubmit", function (a) {
                    var b = a.target, d = b.type;
                    if ((d === "text" || d === "password") && c(b).closest("form").length && a.keyCode === 13)return na("submit", this, arguments)
                })
            } else return false
        }, teardown: function () {
        c.event.remove(this, ".specialSubmit")
    }
    };
    if (!c.support.changeBubbles) {
        var da = /textarea|input|select/i, ea, Fa = function (a) {
            var b = a.type, d = a.value;
            if (b === "radio" || b === "checkbox")d = a.checked; else if (b === "select-multiple")d = a.selectedIndex > -1 ? c.map(a.options, function (f) {
                return f.selected
            }).join("-") : ""; else if (a.nodeName.toLowerCase() === "select")d = a.selectedIndex;
            return d
        }, fa = function (a, b) {
            var d = a.target, f, e;
            if (!(!da.test(d.nodeName) || d.readOnly)) {
                f = c.data(d, "_change_data");
                e = Fa(d);
                if (a.type !== "focusout" || d.type !== "radio")c.data(d, "_change_data",
                    e);
                if (!(f === w || e === f))if (f != null || e) {
                    a.type = "change";
                    return c.event.trigger(a, b, d)
                }
            }
        };
        c.event.special.change = {
            filters: {
                focusout: fa, click: function (a) {
                    var b = a.target, d = b.type;
                    if (d === "radio" || d === "checkbox" || b.nodeName.toLowerCase() === "select")return fa.call(this, a)
                }, keydown: function (a) {
                    var b = a.target, d = b.type;
                    if (a.keyCode === 13 && b.nodeName.toLowerCase() !== "textarea" || a.keyCode === 32 && (d === "checkbox" || d === "radio") || d === "select-multiple")return fa.call(this, a)
                }, beforeactivate: function (a) {
                    a = a.target;
                    c.data(a,
                        "_change_data", Fa(a))
                }
            }, setup: function () {
                if (this.type === "file")return false;
                for (var a in ea)c.event.add(this, a + ".specialChange", ea[a]);
                return da.test(this.nodeName)
            }, teardown: function () {
                c.event.remove(this, ".specialChange");
                return da.test(this.nodeName)
            }
        };
        ea = c.event.special.change.filters
    }
    s.addEventListener && c.each({focus: "focusin", blur: "focusout"}, function (a, b) {
        function d(f) {
            f = c.event.fix(f);
            f.type = b;
            return c.event.handle.call(this, f)
        }

        c.event.special[b] = {
            setup: function () {
                this.addEventListener(a,
                    d, true)
            }, teardown: function () {
                this.removeEventListener(a, d, true)
            }
        }
    });
    c.each(["bind", "one"], function (a, b) {
        c.fn[b] = function (d, f, e) {
            if (typeof d === "object") {
                for (var j in d)this[b](j, f, d[j], e);
                return this
            }
            if (c.isFunction(f)) {
                e = f;
                f = w
            }
            var i = b === "one" ? c.proxy(e, function (k) {
                c(this).unbind(k, i);
                return e.apply(this, arguments)
            }) : e;
            if (d === "unload" && b !== "one")this.one(d, f, e); else {
                j = 0;
                for (var o = this.length; j < o; j++)c.event.add(this[j], d, i, f)
            }
            return this
        }
    });
    c.fn.extend({
        unbind: function (a, b) {
            if (typeof a === "object" && !a.preventDefault)for (var d in a)this.unbind(d, a[d]); else {
                d = 0;
                for (var f = this.length; d < f; d++)c.event.remove(this[d], a, b)
            }
            return this
        }, delegate: function (a, b, d, f) {
            return this.live(b, d, f, a)
        }, undelegate: function (a, b, d) {
            return arguments.length === 0 ? this.unbind("live") : this.die(b, null, d, a)
        }, trigger: function (a, b) {
            return this.each(function () {
                c.event.trigger(a, b, this)
            })
        }, triggerHandler: function (a, b) {
            if (this[0]) {
                a = c.Event(a);
                a.preventDefault();
                a.stopPropagation();
                c.event.trigger(a, b, this[0]);
                return a.result
            }
        },
        toggle: function (a) {
            for (var b = arguments, d = 1; d < b.length;)c.proxy(a, b[d++]);
            return this.click(c.proxy(a, function (f) {
                var e = (c.data(this, "lastToggle" + a.guid) || 0) % d;
                c.data(this, "lastToggle" + a.guid, e + 1);
                f.preventDefault();
                return b[e].apply(this, arguments) || false
            }))
        }, hover: function (a, b) {
            return this.mouseenter(a).mouseleave(b || a)
        }
    });
    var Ga = {focus: "focusin", blur: "focusout", mouseenter: "mouseover", mouseleave: "mouseout"};
    c.each(["live", "die"], function (a, b) {
        c.fn[b] = function (d, f, e, j) {
            var i, o = 0, k, n, r = j || this.selector,
                u = j ? this : c(this.context);
            if (c.isFunction(f)) {
                e = f;
                f = w
            }
            for (d = (d || "").split(" "); (i = d[o++]) != null;) {
                j = O.exec(i);
                k = "";
                if (j) {
                    k = j[0];
                    i = i.replace(O, "")
                }
                if (i === "hover")d.push("mouseenter" + k, "mouseleave" + k); else {
                    n = i;
                    if (i === "focus" || i === "blur") {
                        d.push(Ga[i] + k);
                        i += k
                    } else i = (Ga[i] || i) + k;
                    b === "live" ? u.each(function () {
                        c.event.add(this, pa(i, r), {
                            data: f,
                            selector: r,
                            handler: e,
                            origType: i,
                            origHandler: e,
                            preType: n
                        })
                    }) : u.unbind(pa(i, r), e)
                }
            }
            return this
        }
    });
    c.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error".split(" "),
        function (a, b) {
            c.fn[b] = function (d) {
                return d ? this.bind(b, d) : this.trigger(b)
            };
            if (c.attrFn)c.attrFn[b] = true
        });
    A.attachEvent && !A.addEventListener && A.attachEvent("onunload", function () {
        for (var a in c.cache)if (c.cache[a].handle)try {
            c.event.remove(c.cache[a].handle.elem)
        } catch (b) {
        }
    });
    (function () {
        function a(g) {
            for (var h = "", l, m = 0; g[m]; m++) {
                l = g[m];
                if (l.nodeType === 3 || l.nodeType === 4)h += l.nodeValue; else if (l.nodeType !== 8)h += a(l.childNodes)
            }
            return h
        }

        function b(g, h, l, m, q, p) {
            q = 0;
            for (var v = m.length; q < v; q++) {
                var t = m[q];
                if (t) {
                    t = t[g];
                    for (var y = false; t;) {
                        if (t.sizcache === l) {
                            y = m[t.sizset];
                            break
                        }
                        if (t.nodeType === 1 && !p) {
                            t.sizcache = l;
                            t.sizset = q
                        }
                        if (t.nodeName.toLowerCase() === h) {
                            y = t;
                            break
                        }
                        t = t[g]
                    }
                    m[q] = y
                }
            }
        }

        function d(g, h, l, m, q, p) {
            q = 0;
            for (var v = m.length; q < v; q++) {
                var t = m[q];
                if (t) {
                    t = t[g];
                    for (var y = false; t;) {
                        if (t.sizcache === l) {
                            y = m[t.sizset];
                            break
                        }
                        if (t.nodeType === 1) {
                            if (!p) {
                                t.sizcache = l;
                                t.sizset = q
                            }
                            if (typeof h !== "string") {
                                if (t === h) {
                                    y = true;
                                    break
                                }
                            } else if (k.filter(h, [t]).length > 0) {
                                y = t;
                                break
                            }
                        }
                        t = t[g]
                    }
                    m[q] = y
                }
            }
        }

        var f = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^[\]]*\]|['"][^'"]*['"]|[^[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g,
            e = 0, j = Object.prototype.toString, i = false, o = true;
        [0, 0].sort(function () {
            o = false;
            return 0
        });
        var k = function (g, h, l, m) {
            l = l || [];
            var q = h = h || s;
            if (h.nodeType !== 1 && h.nodeType !== 9)return [];
            if (!g || typeof g !== "string")return l;
            for (var p = [], v, t, y, S, H = true, M = x(h), I = g; (f.exec(""), v = f.exec(I)) !== null;) {
                I = v[3];
                p.push(v[1]);
                if (v[2]) {
                    S = v[3];
                    break
                }
            }
            if (p.length > 1 && r.exec(g))if (p.length === 2 && n.relative[p[0]])t = ga(p[0] + p[1], h); else for (t = n.relative[p[0]] ? [h] : k(p.shift(), h); p.length;) {
                g = p.shift();
                if (n.relative[g])g += p.shift();
                t = ga(g, t)
            } else {
                if (!m && p.length > 1 && h.nodeType === 9 && !M && n.match.ID.test(p[0]) && !n.match.ID.test(p[p.length - 1])) {
                    v = k.find(p.shift(), h, M);
                    h = v.expr ? k.filter(v.expr, v.set)[0] : v.set[0]
                }
                if (h) {
                    v = m ? {
                        expr: p.pop(),
                        set: z(m)
                    } : k.find(p.pop(), p.length === 1 && (p[0] === "~" || p[0] === "+") && h.parentNode ? h.parentNode : h, M);
                    t = v.expr ? k.filter(v.expr, v.set) : v.set;
                    if (p.length > 0)y = z(t); else H = false;
                    for (; p.length;) {
                        var D = p.pop();
                        v = D;
                        if (n.relative[D])v = p.pop(); else D = "";
                        if (v == null)v = h;
                        n.relative[D](y, v, M)
                    }
                } else y = []
            }
            y || (y = t);
            y || k.error(D ||
                g);
            if (j.call(y) === "[object Array]")if (H)if (h && h.nodeType === 1)for (g = 0; y[g] != null; g++) {
                if (y[g] && (y[g] === true || y[g].nodeType === 1 && E(h, y[g])))l.push(t[g])
            } else for (g = 0; y[g] != null; g++)y[g] && y[g].nodeType === 1 && l.push(t[g]); else l.push.apply(l, y); else z(y, l);
            if (S) {
                k(S, q, l, m);
                k.uniqueSort(l)
            }
            return l
        };
        k.uniqueSort = function (g) {
            if (B) {
                i = o;
                g.sort(B);
                if (i)for (var h = 1; h < g.length; h++)g[h] === g[h - 1] && g.splice(h--, 1)
            }
            return g
        };
        k.matches = function (g, h) {
            return k(g, null, null, h)
        };
        k.find = function (g, h, l) {
            var m, q;
            if (!g)return [];
            for (var p = 0, v = n.order.length; p < v; p++) {
                var t = n.order[p];
                if (q = n.leftMatch[t].exec(g)) {
                    var y = q[1];
                    q.splice(1, 1);
                    if (y.substr(y.length - 1) !== "\\") {
                        q[1] = (q[1] || "").replace(/\\/g, "");
                        m = n.find[t](q, h, l);
                        if (m != null) {
                            g = g.replace(n.match[t], "");
                            break
                        }
                    }
                }
            }
            m || (m = h.getElementsByTagName("*"));
            return {set: m, expr: g}
        };
        k.filter = function (g, h, l, m) {
            for (var q = g, p = [], v = h, t, y, S = h && h[0] && x(h[0]); g && h.length;) {
                for (var H in n.filter)if ((t = n.leftMatch[H].exec(g)) != null && t[2]) {
                    var M = n.filter[H], I, D;
                    D = t[1];
                    y = false;
                    t.splice(1, 1);
                    if (D.substr(D.length -
                            1) !== "\\") {
                        if (v === p)p = [];
                        if (n.preFilter[H])if (t = n.preFilter[H](t, v, l, p, m, S)) {
                            if (t === true)continue
                        } else y = I = true;
                        if (t)for (var U = 0; (D = v[U]) != null; U++)if (D) {
                            I = M(D, t, U, v);
                            var Ha = m ^ !!I;
                            if (l && I != null)if (Ha)y = true; else v[U] = false; else if (Ha) {
                                p.push(D);
                                y = true
                            }
                        }
                        if (I !== w) {
                            l || (v = p);
                            g = g.replace(n.match[H], "");
                            if (!y)return [];
                            break
                        }
                    }
                }
                if (g === q)if (y == null)k.error(g); else break;
                q = g
            }
            return v
        };
        k.error = function (g) {
            throw"Syntax error, unrecognized expression: " + g;
        };
        var n = k.selectors = {
            order: ["ID", "NAME", "TAG"], match: {
                ID: /#((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                CLASS: /\.((?:[\w\u00c0-\uFFFF-]|\\.)+)/,
                NAME: /\[name=['"]*((?:[\w\u00c0-\uFFFF-]|\\.)+)['"]*\]/,
                ATTR: /\[\s*((?:[\w\u00c0-\uFFFF-]|\\.)+)\s*(?:(\S?=)\s*(['"]*)(.*?)\3|)\s*\]/,
                TAG: /^((?:[\w\u00c0-\uFFFF\*-]|\\.)+)/,
                CHILD: /:(only|nth|last|first)-child(?:\((even|odd|[\dn+-]*)\))?/,
                POS: /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^-]|$)/,
                PSEUDO: /:((?:[\w\u00c0-\uFFFF-]|\\.)+)(?:\((['"]?)((?:\([^\)]+\)|[^\(\)]*)+)\2\))?/
            }, leftMatch: {}, attrMap: {"class": "className", "for": "htmlFor"}, attrHandle: {
                href: function (g) {
                    return g.getAttribute("href")
                }
            },
            relative: {
                "+": function (g, h) {
                    var l = typeof h === "string", m = l && !/\W/.test(h);
                    l = l && !m;
                    if (m)h = h.toLowerCase();
                    m = 0;
                    for (var q = g.length, p; m < q; m++)if (p = g[m]) {
                        for (; (p = p.previousSibling) && p.nodeType !== 1;);
                        g[m] = l || p && p.nodeName.toLowerCase() === h ? p || false : p === h
                    }
                    l && k.filter(h, g, true)
                }, ">": function (g, h) {
                    var l = typeof h === "string";
                    if (l && !/\W/.test(h)) {
                        h = h.toLowerCase();
                        for (var m = 0, q = g.length; m < q; m++) {
                            var p = g[m];
                            if (p) {
                                l = p.parentNode;
                                g[m] = l.nodeName.toLowerCase() === h ? l : false
                            }
                        }
                    } else {
                        m = 0;
                        for (q = g.length; m < q; m++)if (p = g[m])g[m] =
                            l ? p.parentNode : p.parentNode === h;
                        l && k.filter(h, g, true)
                    }
                }, "": function (g, h, l) {
                    var m = e++, q = d;
                    if (typeof h === "string" && !/\W/.test(h)) {
                        var p = h = h.toLowerCase();
                        q = b
                    }
                    q("parentNode", h, m, g, p, l)
                }, "~": function (g, h, l) {
                    var m = e++, q = d;
                    if (typeof h === "string" && !/\W/.test(h)) {
                        var p = h = h.toLowerCase();
                        q = b
                    }
                    q("previousSibling", h, m, g, p, l)
                }
            }, find: {
                ID: function (g, h, l) {
                    if (typeof h.getElementById !== "undefined" && !l)return (g = h.getElementById(g[1])) ? [g] : []
                }, NAME: function (g, h) {
                    if (typeof h.getElementsByName !== "undefined") {
                        var l = [];
                        h = h.getElementsByName(g[1]);
                        for (var m = 0, q = h.length; m < q; m++)h[m].getAttribute("name") === g[1] && l.push(h[m]);
                        return l.length === 0 ? null : l
                    }
                }, TAG: function (g, h) {
                    return h.getElementsByTagName(g[1])
                }
            }, preFilter: {
                CLASS: function (g, h, l, m, q, p) {
                    g = " " + g[1].replace(/\\/g, "") + " ";
                    if (p)return g;
                    p = 0;
                    for (var v; (v = h[p]) != null; p++)if (v)if (q ^ (v.className && (" " + v.className + " ").replace(/[\t\n]/g, " ").indexOf(g) >= 0))l || m.push(v); else if (l)h[p] = false;
                    return false
                }, ID: function (g) {
                    return g[1].replace(/\\/g, "")
                }, TAG: function (g) {
                    return g[1].toLowerCase()
                },
                CHILD: function (g) {
                    if (g[1] === "nth") {
                        var h = /(-?)(\d*)n((?:\+|-)?\d*)/.exec(g[2] === "even" && "2n" || g[2] === "odd" && "2n+1" || !/\D/.test(g[2]) && "0n+" + g[2] || g[2]);
                        g[2] = h[1] + (h[2] || 1) - 0;
                        g[3] = h[3] - 0
                    }
                    g[0] = e++;
                    return g
                }, ATTR: function (g, h, l, m, q, p) {
                    h = g[1].replace(/\\/g, "");
                    if (!p && n.attrMap[h])g[1] = n.attrMap[h];
                    if (g[2] === "~=")g[4] = " " + g[4] + " ";
                    return g
                }, PSEUDO: function (g, h, l, m, q) {
                    if (g[1] === "not")if ((f.exec(g[3]) || "").length > 1 || /^\w/.test(g[3]))g[3] = k(g[3], null, null, h); else {
                        g = k.filter(g[3], h, l, true ^ q);
                        l || m.push.apply(m,
                            g);
                        return false
                    } else if (n.match.POS.test(g[0]) || n.match.CHILD.test(g[0]))return true;
                    return g
                }, POS: function (g) {
                    g.unshift(true);
                    return g
                }
            }, filters: {
                enabled: function (g) {
                    return g.disabled === false && g.type !== "hidden"
                }, disabled: function (g) {
                    return g.disabled === true
                }, checked: function (g) {
                    return g.checked === true
                }, selected: function (g) {
                    return g.selected === true
                }, parent: function (g) {
                    return !!g.firstChild
                }, empty: function (g) {
                    return !g.firstChild
                }, has: function (g, h, l) {
                    return !!k(l[3], g).length
                }, header: function (g) {
                    return /h\d/i.test(g.nodeName)
                },
                text: function (g) {
                    return "text" === g.type
                }, radio: function (g) {
                    return "radio" === g.type
                }, checkbox: function (g) {
                    return "checkbox" === g.type
                }, file: function (g) {
                    return "file" === g.type
                }, password: function (g) {
                    return "password" === g.type
                }, submit: function (g) {
                    return "submit" === g.type
                }, image: function (g) {
                    return "image" === g.type
                }, reset: function (g) {
                    return "reset" === g.type
                }, button: function (g) {
                    return "button" === g.type || g.nodeName.toLowerCase() === "button"
                }, input: function (g) {
                    return /input|select|textarea|button/i.test(g.nodeName)
                }
            },
            setFilters: {
                first: function (g, h) {
                    return h === 0
                }, last: function (g, h, l, m) {
                    return h === m.length - 1
                }, even: function (g, h) {
                    return h % 2 === 0
                }, odd: function (g, h) {
                    return h % 2 === 1
                }, lt: function (g, h, l) {
                    return h < l[3] - 0
                }, gt: function (g, h, l) {
                    return h > l[3] - 0
                }, nth: function (g, h, l) {
                    return l[3] - 0 === h
                }, eq: function (g, h, l) {
                    return l[3] - 0 === h
                }
            }, filter: {
                PSEUDO: function (g, h, l, m) {
                    var q = h[1], p = n.filters[q];
                    if (p)return p(g, l, h, m); else if (q === "contains")return (g.textContent || g.innerText || a([g]) || "").indexOf(h[3]) >= 0; else if (q === "not") {
                        h =
                            h[3];
                        l = 0;
                        for (m = h.length; l < m; l++)if (h[l] === g)return false;
                        return true
                    } else k.error("Syntax error, unrecognized expression: " + q)
                }, CHILD: function (g, h) {
                    var l = h[1], m = g;
                    switch (l) {
                        case "only":
                        case "first":
                            for (; m = m.previousSibling;)if (m.nodeType === 1)return false;
                            if (l === "first")return true;
                            m = g;
                        case "last":
                            for (; m = m.nextSibling;)if (m.nodeType === 1)return false;
                            return true;
                        case "nth":
                            l = h[2];
                            var q = h[3];
                            if (l === 1 && q === 0)return true;
                            h = h[0];
                            var p = g.parentNode;
                            if (p && (p.sizcache !== h || !g.nodeIndex)) {
                                var v = 0;
                                for (m = p.firstChild; m; m =
                                    m.nextSibling)if (m.nodeType === 1)m.nodeIndex = ++v;
                                p.sizcache = h
                            }
                            g = g.nodeIndex - q;
                            return l === 0 ? g === 0 : g % l === 0 && g / l >= 0
                    }
                }, ID: function (g, h) {
                    return g.nodeType === 1 && g.getAttribute("id") === h
                }, TAG: function (g, h) {
                    return h === "*" && g.nodeType === 1 || g.nodeName.toLowerCase() === h
                }, CLASS: function (g, h) {
                    return (" " + (g.className || g.getAttribute("class")) + " ").indexOf(h) > -1
                }, ATTR: function (g, h) {
                    var l = h[1];
                    g = n.attrHandle[l] ? n.attrHandle[l](g) : g[l] != null ? g[l] : g.getAttribute(l);
                    l = g + "";
                    var m = h[2];
                    h = h[4];
                    return g == null ? m === "!=" : m ===
                    "=" ? l === h : m === "*=" ? l.indexOf(h) >= 0 : m === "~=" ? (" " + l + " ").indexOf(h) >= 0 : !h ? l && g !== false : m === "!=" ? l !== h : m === "^=" ? l.indexOf(h) === 0 : m === "$=" ? l.substr(l.length - h.length) === h : m === "|=" ? l === h || l.substr(0, h.length + 1) === h + "-" : false
                }, POS: function (g, h, l, m) {
                    var q = n.setFilters[h[2]];
                    if (q)return q(g, l, h, m)
                }
            }
        }, r = n.match.POS;
        for (var u in n.match) {
            n.match[u] = new RegExp(n.match[u].source + /(?![^\[]*\])(?![^\(]*\))/.source);
            n.leftMatch[u] = new RegExp(/(^(?:.|\r|\n)*?)/.source + n.match[u].source.replace(/\\(\d+)/g, function (g,
                                                                                                                    h) {
                    return "\\" + (h - 0 + 1)
                }))
        }
        var z = function (g, h) {
            g = Array.prototype.slice.call(g, 0);
            if (h) {
                h.push.apply(h, g);
                return h
            }
            return g
        };
        try {
            Array.prototype.slice.call(s.documentElement.childNodes, 0)
        } catch (C) {
            z = function (g, h) {
                h = h || [];
                if (j.call(g) === "[object Array]")Array.prototype.push.apply(h, g); else if (typeof g.length === "number")for (var l = 0, m = g.length; l < m; l++)h.push(g[l]); else for (l = 0; g[l]; l++)h.push(g[l]);
                return h
            }
        }
        var B;
        if (s.documentElement.compareDocumentPosition)B = function (g, h) {
            if (!g.compareDocumentPosition || !h.compareDocumentPosition) {
                if (g == h)i = true;
                return g.compareDocumentPosition ? -1 : 1
            }
            g = g.compareDocumentPosition(h) & 4 ? -1 : g === h ? 0 : 1;
            if (g === 0)i = true;
            return g
        }; else if ("sourceIndex" in s.documentElement)B = function (g, h) {
            if (!g.sourceIndex || !h.sourceIndex) {
                if (g == h)i = true;
                return g.sourceIndex ? -1 : 1
            }
            g = g.sourceIndex - h.sourceIndex;
            if (g === 0)i = true;
            return g
        }; else if (s.createRange)B = function (g, h) {
            if (!g.ownerDocument || !h.ownerDocument) {
                if (g == h)i = true;
                return g.ownerDocument ? -1 : 1
            }
            var l = g.ownerDocument.createRange(), m =
                h.ownerDocument.createRange();
            l.setStart(g, 0);
            l.setEnd(g, 0);
            m.setStart(h, 0);
            m.setEnd(h, 0);
            g = l.compareBoundaryPoints(Range.START_TO_END, m);
            if (g === 0)i = true;
            return g
        };
        (function () {
            var g = s.createElement("div"), h = "script" + (new Date).getTime();
            g.innerHTML = "<a name='" + h + "'/>";
            var l = s.documentElement;
            l.insertBefore(g, l.firstChild);
            if (s.getElementById(h)) {
                n.find.ID = function (m, q, p) {
                    if (typeof q.getElementById !== "undefined" && !p)return (q = q.getElementById(m[1])) ? q.id === m[1] || typeof q.getAttributeNode !== "undefined" &&
                    q.getAttributeNode("id").nodeValue === m[1] ? [q] : w : []
                };
                n.filter.ID = function (m, q) {
                    var p = typeof m.getAttributeNode !== "undefined" && m.getAttributeNode("id");
                    return m.nodeType === 1 && p && p.nodeValue === q
                }
            }
            l.removeChild(g);
            l = g = null
        })();
        (function () {
            var g = s.createElement("div");
            g.appendChild(s.createComment(""));
            if (g.getElementsByTagName("*").length > 0)n.find.TAG = function (h, l) {
                l = l.getElementsByTagName(h[1]);
                if (h[1] === "*") {
                    h = [];
                    for (var m = 0; l[m]; m++)l[m].nodeType === 1 && h.push(l[m]);
                    l = h
                }
                return l
            };
            g.innerHTML = "<a href='#'></a>";
            if (g.firstChild && typeof g.firstChild.getAttribute !== "undefined" && g.firstChild.getAttribute("href") !== "#")n.attrHandle.href = function (h) {
                return h.getAttribute("href", 2)
            };
            g = null
        })();
        s.querySelectorAll && function () {
            var g = k, h = s.createElement("div");
            h.innerHTML = "<p class='TEST'></p>";
            if (!(h.querySelectorAll && h.querySelectorAll(".TEST").length === 0)) {
                k = function (m, q, p, v) {
                    q = q || s;
                    if (!v && q.nodeType === 9 && !x(q))try {
                        return z(q.querySelectorAll(m), p)
                    } catch (t) {
                    }
                    return g(m, q, p, v)
                };
                for (var l in g)k[l] = g[l];
                h = null
            }
        }();
        (function () {
            var g = s.createElement("div");
            g.innerHTML = "<div class='test e'></div><div class='test'></div>";
            if (!(!g.getElementsByClassName || g.getElementsByClassName("e").length === 0)) {
                g.lastChild.className = "e";
                if (g.getElementsByClassName("e").length !== 1) {
                    n.order.splice(1, 0, "CLASS");
                    n.find.CLASS = function (h, l, m) {
                        if (typeof l.getElementsByClassName !== "undefined" && !m)return l.getElementsByClassName(h[1])
                    };
                    g = null
                }
            }
        })();
        var E = s.compareDocumentPosition ? function (g, h) {
            return !!(g.compareDocumentPosition(h) & 16)
        } :
            function (g, h) {
                return g !== h && (g.contains ? g.contains(h) : true)
            }, x = function (g) {
            return (g = (g ? g.ownerDocument || g : 0).documentElement) ? g.nodeName !== "HTML" : false
        }, ga = function (g, h) {
            var l = [], m = "", q;
            for (h = h.nodeType ? [h] : h; q = n.match.PSEUDO.exec(g);) {
                m += q[0];
                g = g.replace(n.match.PSEUDO, "")
            }
            g = n.relative[g] ? g + "*" : g;
            q = 0;
            for (var p = h.length; q < p; q++)k(g, h[q], l);
            return k.filter(m, l)
        };
        c.find = k;
        c.expr = k.selectors;
        c.expr[":"] = c.expr.filters;
        c.unique = k.uniqueSort;
        c.text = a;
        c.isXMLDoc = x;
        c.contains = E
    })();
    var eb = /Until$/, fb = /^(?:parents|prevUntil|prevAll)/,
        gb = /,/;
    R = Array.prototype.slice;
    var Ia = function (a, b, d) {
        if (c.isFunction(b))return c.grep(a, function (e, j) {
            return !!b.call(e, j, e) === d
        }); else if (b.nodeType)return c.grep(a, function (e) {
            return e === b === d
        }); else if (typeof b === "string") {
            var f = c.grep(a, function (e) {
                return e.nodeType === 1
            });
            if (Ua.test(b))return c.filter(b, f, !d); else b = c.filter(b, f)
        }
        return c.grep(a, function (e) {
            return c.inArray(e, b) >= 0 === d
        })
    };
    c.fn.extend({
        find: function (a) {
            for (var b = this.pushStack("", "find", a), d = 0, f = 0, e = this.length; f < e; f++) {
                d = b.length;
                c.find(a, this[f], b);
                if (f > 0)for (var j = d; j < b.length; j++)for (var i = 0; i < d; i++)if (b[i] === b[j]) {
                    b.splice(j--, 1);
                    break
                }
            }
            return b
        }, has: function (a) {
            var b = c(a);
            return this.filter(function () {
                for (var d = 0, f = b.length; d < f; d++)if (c.contains(this, b[d]))return true
            })
        }, not: function (a) {
            return this.pushStack(Ia(this, a, false), "not", a)
        }, filter: function (a) {
            return this.pushStack(Ia(this, a, true), "filter", a)
        }, is: function (a) {
            return !!a && c.filter(a, this).length > 0
        }, closest: function (a, b) {
            if (c.isArray(a)) {
                var d = [], f = this[0], e, j =
                {}, i;
                if (f && a.length) {
                    e = 0;
                    for (var o = a.length; e < o; e++) {
                        i = a[e];
                        j[i] || (j[i] = c.expr.match.POS.test(i) ? c(i, b || this.context) : i)
                    }
                    for (; f && f.ownerDocument && f !== b;) {
                        for (i in j) {
                            e = j[i];
                            if (e.jquery ? e.index(f) > -1 : c(f).is(e)) {
                                d.push({selector: i, elem: f});
                                delete j[i]
                            }
                        }
                        f = f.parentNode
                    }
                }
                return d
            }
            var k = c.expr.match.POS.test(a) ? c(a, b || this.context) : null;
            return this.map(function (n, r) {
                for (; r && r.ownerDocument && r !== b;) {
                    if (k ? k.index(r) > -1 : c(r).is(a))return r;
                    r = r.parentNode
                }
                return null
            })
        }, index: function (a) {
            if (!a || typeof a ===
                "string")return c.inArray(this[0], a ? c(a) : this.parent().children());
            return c.inArray(a.jquery ? a[0] : a, this)
        }, add: function (a, b) {
            a = typeof a === "string" ? c(a, b || this.context) : c.makeArray(a);
            b = c.merge(this.get(), a);
            return this.pushStack(qa(a[0]) || qa(b[0]) ? b : c.unique(b))
        }, andSelf: function () {
            return this.add(this.prevObject)
        }
    });
    c.each({
        parent: function (a) {
            return (a = a.parentNode) && a.nodeType !== 11 ? a : null
        }, parents: function (a) {
            return c.dir(a, "parentNode")
        }, parentsUntil: function (a, b, d) {
            return c.dir(a, "parentNode",
                d)
        }, next: function (a) {
            return c.nth(a, 2, "nextSibling")
        }, prev: function (a) {
            return c.nth(a, 2, "previousSibling")
        }, nextAll: function (a) {
            return c.dir(a, "nextSibling")
        }, prevAll: function (a) {
            return c.dir(a, "previousSibling")
        }, nextUntil: function (a, b, d) {
            return c.dir(a, "nextSibling", d)
        }, prevUntil: function (a, b, d) {
            return c.dir(a, "previousSibling", d)
        }, siblings: function (a) {
            return c.sibling(a.parentNode.firstChild, a)
        }, children: function (a) {
            return c.sibling(a.firstChild)
        }, contents: function (a) {
            return c.nodeName(a, "iframe") ?
            a.contentDocument || a.contentWindow.document : c.makeArray(a.childNodes)
        }
    }, function (a, b) {
        c.fn[a] = function (d, f) {
            var e = c.map(this, b, d);
            eb.test(a) || (f = d);
            if (f && typeof f === "string")e = c.filter(f, e);
            e = this.length > 1 ? c.unique(e) : e;
            if ((this.length > 1 || gb.test(f)) && fb.test(a))e = e.reverse();
            return this.pushStack(e, a, R.call(arguments).join(","))
        }
    });
    c.extend({
        filter: function (a, b, d) {
            if (d)a = ":not(" + a + ")";
            return c.find.matches(a, b)
        }, dir: function (a, b, d) {
            var f = [];
            for (a = a[b]; a && a.nodeType !== 9 && (d === w || a.nodeType !== 1 || !c(a).is(d));) {
                a.nodeType ===
                1 && f.push(a);
                a = a[b]
            }
            return f
        }, nth: function (a, b, d) {
            b = b || 1;
            for (var f = 0; a; a = a[d])if (a.nodeType === 1 && ++f === b)break;
            return a
        }, sibling: function (a, b) {
            for (var d = []; a; a = a.nextSibling)a.nodeType === 1 && a !== b && d.push(a);
            return d
        }
    });
    var Ja = / jQuery\d+="(?:\d+|null)"/g, V = /^\s+/, Ka = /(<([\w:]+)[^>]*?)\/>/g, hb = /^(?:area|br|col|embed|hr|img|input|link|meta|param)$/i, La = /<([\w:]+)/, ib = /<tbody/i, jb = /<|&#?\w+;/, ta = /<script|<object|<embed|<option|<style/i, ua = /checked\s*(?:[^=]|=\s*.checked.)/i, Ma = function (a, b, d) {
        return hb.test(d) ?
            a : b + "></" + d + ">"
    }, F = {
        option: [1, "<select multiple='multiple'>", "</select>"],
        legend: [1, "<fieldset>", "</fieldset>"],
        thead: [1, "<table>", "</table>"],
        tr: [2, "<table><tbody>", "</tbody></table>"],
        td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
        col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
        area: [1, "<map>", "</map>"],
        _default: [0, "", ""]
    };
    F.optgroup = F.option;
    F.tbody = F.tfoot = F.colgroup = F.caption = F.thead;
    F.th = F.td;
    if (!c.support.htmlSerialize)F._default = [1, "div<div>", "</div>"];
    c.fn.extend({
        text: function (a) {
            if (c.isFunction(a))return this.each(function (b) {
                var d =
                    c(this);
                d.text(a.call(this, b, d.text()))
            });
            if (typeof a !== "object" && a !== w)return this.empty().append((this[0] && this[0].ownerDocument || s).createTextNode(a));
            return c.text(this)
        }, wrapAll: function (a) {
            if (c.isFunction(a))return this.each(function (d) {
                c(this).wrapAll(a.call(this, d))
            });
            if (this[0]) {
                var b = c(a, this[0].ownerDocument).eq(0).clone(true);
                this[0].parentNode && b.insertBefore(this[0]);
                b.map(function () {
                    for (var d = this; d.firstChild && d.firstChild.nodeType === 1;)d = d.firstChild;
                    return d
                }).append(this)
            }
            return this
        },
        wrapInner: function (a) {
            if (c.isFunction(a))return this.each(function (b) {
                c(this).wrapInner(a.call(this, b))
            });
            return this.each(function () {
                var b = c(this), d = b.contents();
                d.length ? d.wrapAll(a) : b.append(a)
            })
        }, wrap: function (a) {
            return this.each(function () {
                c(this).wrapAll(a)
            })
        }, unwrap: function () {
            return this.parent().each(function () {
                c.nodeName(this, "body") || c(this).replaceWith(this.childNodes)
            }).end()
        }, append: function () {
            return this.domManip(arguments, true, function (a) {
                this.nodeType === 1 && this.appendChild(a)
            })
        },
        prepend: function () {
            return this.domManip(arguments, true, function (a) {
                this.nodeType === 1 && this.insertBefore(a, this.firstChild)
            })
        }, before: function () {
            if (this[0] && this[0].parentNode)return this.domManip(arguments, false, function (b) {
                this.parentNode.insertBefore(b, this)
            }); else if (arguments.length) {
                var a = c(arguments[0]);
                a.push.apply(a, this.toArray());
                return this.pushStack(a, "before", arguments)
            }
        }, after: function () {
            if (this[0] && this[0].parentNode)return this.domManip(arguments, false, function (b) {
                this.parentNode.insertBefore(b,
                    this.nextSibling)
            }); else if (arguments.length) {
                var a = this.pushStack(this, "after", arguments);
                a.push.apply(a, c(arguments[0]).toArray());
                return a
            }
        }, remove: function (a, b) {
            for (var d = 0, f; (f = this[d]) != null; d++)if (!a || c.filter(a, [f]).length) {
                if (!b && f.nodeType === 1) {
                    c.cleanData(f.getElementsByTagName("*"));
                    c.cleanData([f])
                }
                f.parentNode && f.parentNode.removeChild(f)
            }
            return this
        }, empty: function () {
            for (var a = 0, b; (b = this[a]) != null; a++)for (b.nodeType === 1 && c.cleanData(b.getElementsByTagName("*")); b.firstChild;)b.removeChild(b.firstChild);
            return this
        }, clone: function (a) {
            var b = this.map(function () {
                if (!c.support.noCloneEvent && !c.isXMLDoc(this)) {
                    var d = this.outerHTML, f = this.ownerDocument;
                    if (!d) {
                        d = f.createElement("div");
                        d.appendChild(this.cloneNode(true));
                        d = d.innerHTML
                    }
                    return c.clean([d.replace(Ja, "").replace(/=([^="'>\s]+\/)>/g, '="$1">').replace(V, "")], f)[0]
                } else return this.cloneNode(true)
            });
            if (a === true) {
                ra(this, b);
                ra(this.find("*"), b.find("*"))
            }
            return b
        }, html: function (a) {
            if (a === w)return this[0] && this[0].nodeType === 1 ? this[0].innerHTML.replace(Ja,
                "") : null; else if (typeof a === "string" && !ta.test(a) && (c.support.leadingWhitespace || !V.test(a)) && !F[(La.exec(a) || ["", ""])[1].toLowerCase()]) {
                a = a.replace(Ka, Ma);
                try {
                    for (var b = 0, d = this.length; b < d; b++)if (this[b].nodeType === 1) {
                        c.cleanData(this[b].getElementsByTagName("*"));
                        this[b].innerHTML = a
                    }
                } catch (f) {
                    this.empty().append(a)
                }
            } else c.isFunction(a) ? this.each(function (e) {
                var j = c(this), i = j.html();
                j.empty().append(function () {
                    return a.call(this, e, i)
                })
            }) : this.empty().append(a);
            return this
        }, replaceWith: function (a) {
            if (this[0] &&
                this[0].parentNode) {
                if (c.isFunction(a))return this.each(function (b) {
                    var d = c(this), f = d.html();
                    d.replaceWith(a.call(this, b, f))
                });
                if (typeof a !== "string")a = c(a).detach();
                return this.each(function () {
                    var b = this.nextSibling, d = this.parentNode;
                    c(this).remove();
                    b ? c(b).before(a) : c(d).append(a)
                })
            } else return this.pushStack(c(c.isFunction(a) ? a() : a), "replaceWith", a)
        }, detach: function (a) {
            return this.remove(a, true)
        }, domManip: function (a, b, d) {
            function f(u) {
                return c.nodeName(u, "table") ? u.getElementsByTagName("tbody")[0] ||
                u.appendChild(u.ownerDocument.createElement("tbody")) : u
            }

            var e, j, i = a[0], o = [], k;
            if (!c.support.checkClone && arguments.length === 3 && typeof i === "string" && ua.test(i))return this.each(function () {
                c(this).domManip(a, b, d, true)
            });
            if (c.isFunction(i))return this.each(function (u) {
                var z = c(this);
                a[0] = i.call(this, u, b ? z.html() : w);
                z.domManip(a, b, d)
            });
            if (this[0]) {
                e = i && i.parentNode;
                e = c.support.parentNode && e && e.nodeType === 11 && e.childNodes.length === this.length ? {fragment: e} : sa(a, this, o);
                k = e.fragment;
                if (j = k.childNodes.length ===
                    1 ? (k = k.firstChild) : k.firstChild) {
                    b = b && c.nodeName(j, "tr");
                    for (var n = 0, r = this.length; n < r; n++)d.call(b ? f(this[n], j) : this[n], n > 0 || e.cacheable || this.length > 1 ? k.cloneNode(true) : k)
                }
                o.length && c.each(o, Qa)
            }
            return this
        }
    });
    c.fragments = {};
    c.each({
        appendTo: "append",
        prependTo: "prepend",
        insertBefore: "before",
        insertAfter: "after",
        replaceAll: "replaceWith"
    }, function (a, b) {
        c.fn[a] = function (d) {
            var f = [];
            d = c(d);
            var e = this.length === 1 && this[0].parentNode;
            if (e && e.nodeType === 11 && e.childNodes.length === 1 && d.length === 1) {
                d[b](this[0]);
                return this
            } else {
                e = 0;
                for (var j = d.length; e < j; e++) {
                    var i = (e > 0 ? this.clone(true) : this).get();
                    c.fn[b].apply(c(d[e]), i);
                    f = f.concat(i)
                }
                return this.pushStack(f, a, d.selector)
            }
        }
    });
    c.extend({
        clean: function (a, b, d, f) {
            b = b || s;
            if (typeof b.createElement === "undefined")b = b.ownerDocument || b[0] && b[0].ownerDocument || s;
            for (var e = [], j = 0, i; (i = a[j]) != null; j++) {
                if (typeof i === "number")i += "";
                if (i) {
                    if (typeof i === "string" && !jb.test(i))i = b.createTextNode(i); else if (typeof i === "string") {
                        i = i.replace(Ka, Ma);
                        var o = (La.exec(i) || ["",
                            ""])[1].toLowerCase(), k = F[o] || F._default, n = k[0], r = b.createElement("div");
                        for (r.innerHTML = k[1] + i + k[2]; n--;)r = r.lastChild;
                        if (!c.support.tbody) {
                            n = ib.test(i);
                            o = o === "table" && !n ? r.firstChild && r.firstChild.childNodes : k[1] === "<table>" && !n ? r.childNodes : [];
                            for (k = o.length - 1; k >= 0; --k)c.nodeName(o[k], "tbody") && !o[k].childNodes.length && o[k].parentNode.removeChild(o[k])
                        }
                        !c.support.leadingWhitespace && V.test(i) && r.insertBefore(b.createTextNode(V.exec(i)[0]), r.firstChild);
                        i = r.childNodes
                    }
                    if (i.nodeType)e.push(i); else e =
                        c.merge(e, i)
                }
            }
            if (d)for (j = 0; e[j]; j++)if (f && c.nodeName(e[j], "script") && (!e[j].type || e[j].type.toLowerCase() === "text/javascript"))f.push(e[j].parentNode ? e[j].parentNode.removeChild(e[j]) : e[j]); else {
                e[j].nodeType === 1 && e.splice.apply(e, [j + 1, 0].concat(c.makeArray(e[j].getElementsByTagName("script"))));
                d.appendChild(e[j])
            }
            return e
        }, cleanData: function (a) {
            for (var b, d, f = c.cache, e = c.event.special, j = c.support.deleteExpando, i = 0, o; (o = a[i]) != null; i++)if (d = o[c.expando]) {
                b = f[d];
                if (b.events)for (var k in b.events)e[k] ?
                    c.event.remove(o, k) : Ca(o, k, b.handle);
                if (j)delete o[c.expando]; else o.removeAttribute && o.removeAttribute(c.expando);
                delete f[d]
            }
        }
    });
    var kb = /z-?index|font-?weight|opacity|zoom|line-?height/i, Na = /alpha\([^)]*\)/, Oa = /opacity=([^)]*)/, ha = /float/i, ia = /-([a-z])/ig, lb = /([A-Z])/g, mb = /^-?\d+(?:px)?$/i, nb = /^-?\d/, ob = {
        position: "absolute",
        visibility: "hidden",
        display: "block"
    }, pb = ["Left", "Right"], qb = ["Top", "Bottom"], rb = s.defaultView && s.defaultView.getComputedStyle, Pa = c.support.cssFloat ? "cssFloat" : "styleFloat", ja =
        function (a, b) {
            return b.toUpperCase()
        };
    c.fn.css = function (a, b) {
        return X(this, a, b, true, function (d, f, e) {
            if (e === w)return c.curCSS(d, f);
            if (typeof e === "number" && !kb.test(f))e += "px";
            c.style(d, f, e)
        })
    };
    c.extend({
        style: function (a, b, d) {
            if (!a || a.nodeType === 3 || a.nodeType === 8)return w;
            if ((b === "width" || b === "height") && parseFloat(d) < 0)d = w;
            var f = a.style || a, e = d !== w;
            if (!c.support.opacity && b === "opacity") {
                if (e) {
                    f.zoom = 1;
                    b = parseInt(d, 10) + "" === "NaN" ? "" : "alpha(opacity=" + d * 100 + ")";
                    a = f.filter || c.curCSS(a, "filter") || "";
                    f.filter =
                        Na.test(a) ? a.replace(Na, b) : b
                }
                return f.filter && f.filter.indexOf("opacity=") >= 0 ? parseFloat(Oa.exec(f.filter)[1]) / 100 + "" : ""
            }
            if (ha.test(b))b = Pa;
            b = b.replace(ia, ja);
            if (e)f[b] = d;
            return f[b]
        }, css: function (a, b, d, f) {
            if (b === "width" || b === "height") {
                var e, j = b === "width" ? pb : qb;

                function i() {
                    e = b === "width" ? a.offsetWidth : a.offsetHeight;
                    f !== "border" && c.each(j, function () {
                        f || (e -= parseFloat(c.curCSS(a, "padding" + this, true)) || 0);
                        if (f === "margin")e += parseFloat(c.curCSS(a, "margin" + this, true)) || 0; else e -= parseFloat(c.curCSS(a,
                                "border" + this + "Width", true)) || 0
                    })
                }

                a.offsetWidth !== 0 ? i() : c.swap(a, ob, i);
                return Math.max(0, Math.round(e))
            }
            return c.curCSS(a, b, d)
        }, curCSS: function (a, b, d) {
            var f, e = a.style;
            if (!c.support.opacity && b === "opacity" && a.currentStyle) {
                f = Oa.test(a.currentStyle.filter || "") ? parseFloat(RegExp.$1) / 100 + "" : "";
                return f === "" ? "1" : f
            }
            if (ha.test(b))b = Pa;
            if (!d && e && e[b])f = e[b]; else if (rb) {
                if (ha.test(b))b = "float";
                b = b.replace(lb, "-$1").toLowerCase();
                e = a.ownerDocument.defaultView;
                if (!e)return null;
                if (a = e.getComputedStyle(a, null))f =
                    a.getPropertyValue(b);
                if (b === "opacity" && f === "")f = "1"
            } else if (a.currentStyle) {
                d = b.replace(ia, ja);
                f = a.currentStyle[b] || a.currentStyle[d];
                if (!mb.test(f) && nb.test(f)) {
                    b = e.left;
                    var j = a.runtimeStyle.left;
                    a.runtimeStyle.left = a.currentStyle.left;
                    e.left = d === "fontSize" ? "1em" : f || 0;
                    f = e.pixelLeft + "px";
                    e.left = b;
                    a.runtimeStyle.left = j
                }
            }
            return f
        }, swap: function (a, b, d) {
            var f = {};
            for (var e in b) {
                f[e] = a.style[e];
                a.style[e] = b[e]
            }
            d.call(a);
            for (e in b)a.style[e] = f[e]
        }
    });
    if (c.expr && c.expr.filters) {
        c.expr.filters.hidden = function (a) {
            var b =
                a.offsetWidth, d = a.offsetHeight, f = a.nodeName.toLowerCase() === "tr";
            return b === 0 && d === 0 && !f ? true : b > 0 && d > 0 && !f ? false : c.curCSS(a, "display") === "none"
        };
        c.expr.filters.visible = function (a) {
            return !c.expr.filters.hidden(a)
        }
    }
    var sb = J(), tb = /<script(.|\s)*?\/script>/gi, ub = /select|textarea/i, vb = /color|date|datetime|email|hidden|month|number|password|range|search|tel|text|time|url|week/i, N = /=\?(&|$)/, ka = /\?/, wb = /(\?|&)_=.*?(&|$)/, xb = /^(\w+:)?\/\/([^\/?#]+)/, yb = /%20/g, zb = c.fn.load;
    c.fn.extend({
        load: function (a, b, d) {
            if (typeof a !==
                "string")return zb.call(this, a); else if (!this.length)return this;
            var f = a.indexOf(" ");
            if (f >= 0) {
                var e = a.slice(f, a.length);
                a = a.slice(0, f)
            }
            f = "GET";
            if (b)if (c.isFunction(b)) {
                d = b;
                b = null
            } else if (typeof b === "object") {
                b = c.param(b, c.ajaxSettings.traditional);
                f = "POST"
            }
            var j = this;
            c.ajax({
                url: a, type: f, dataType: "html", data: b, complete: function (i, o) {
                    if (o === "success" || o === "notmodified")j.html(e ? c("<div />").append(i.responseText.replace(tb, "")).find(e) : i.responseText);
                    d && j.each(d, [i.responseText, o, i])
                }
            });
            return this
        },
        serialize: function () {
            return c.param(this.serializeArray())
        }, serializeArray: function () {
            return this.map(function () {
                return this.elements ? c.makeArray(this.elements) : this
            }).filter(function () {
                return this.name && !this.disabled && (this.checked || ub.test(this.nodeName) || vb.test(this.type))
            }).map(function (a, b) {
                a = c(this).val();
                return a == null ? null : c.isArray(a) ? c.map(a, function (d) {
                    return {name: b.name, value: d}
                }) : {name: b.name, value: a}
            }).get()
        }
    });
    c.each("ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split(" "),
        function (a, b) {
            c.fn[b] = function (d) {
                return this.bind(b, d)
            }
        });
    c.extend({
        get: function (a, b, d, f) {
            if (c.isFunction(b)) {
                f = f || d;
                d = b;
                b = null
            }
            return c.ajax({type: "GET", url: a, data: b, success: d, dataType: f})
        }, getScript: function (a, b) {
            return c.get(a, null, b, "script")
        }, getJSON: function (a, b, d) {
            return c.get(a, b, d, "json")
        }, post: function (a, b, d, f) {
            if (c.isFunction(b)) {
                f = f || d;
                d = b;
                b = {}
            }
            return c.ajax({type: "POST", url: a, data: b, success: d, dataType: f})
        }, ajaxSetup: function (a) {
            c.extend(c.ajaxSettings, a)
        }, ajaxSettings: {
            url: location.href,
            global: true,
            type: "GET",
            contentType: "application/x-www-form-urlencoded",
            processData: true,
            async: true,
            xhr: A.XMLHttpRequest && (A.location.protocol !== "file:" || !A.ActiveXObject) ? function () {
                return new A.XMLHttpRequest
            } : function () {
                try {
                    return new A.ActiveXObject("Microsoft.XMLHTTP")
                } catch (a) {
                }
            },
            accepts: {
                xml: "application/xml, text/xml",
                html: "text/html",
                script: "text/javascript, application/javascript",
                json: "application/json, text/javascript",
                text: "text/plain",
                _default: "*/*"
            }
        }, lastModified: {}, etag: {}, ajax: function (a) {
            function b() {
                e.success &&
                e.success.call(k, o, i, x);
                e.global && f("ajaxSuccess", [x, e])
            }

            function d() {
                e.complete && e.complete.call(k, x, i);
                e.global && f("ajaxComplete", [x, e]);
                e.global && !--c.active && c.event.trigger("ajaxStop")
            }

            function f(q, p) {
                (e.context ? c(e.context) : c.event).trigger(q, p)
            }

            var e = c.extend(true, {}, c.ajaxSettings, a), j, i, o, k = a && a.context || e, n = e.type.toUpperCase();
            if (e.data && e.processData && typeof e.data !== "string")e.data = c.param(e.data, e.traditional);
            if (e.dataType === "jsonp") {
                if (n === "GET")N.test(e.url) || (e.url += (ka.test(e.url) ?
                        "&" : "?") + (e.jsonp || "callback") + "=?"); else if (!e.data || !N.test(e.data))e.data = (e.data ? e.data + "&" : "") + (e.jsonp || "callback") + "=?";
                e.dataType = "json"
            }
            if (e.dataType === "json" && (e.data && N.test(e.data) || N.test(e.url))) {
                j = e.jsonpCallback || "jsonp" + sb++;
                if (e.data)e.data = (e.data + "").replace(N, "=" + j + "$1");
                e.url = e.url.replace(N, "=" + j + "$1");
                e.dataType = "script";
                A[j] = A[j] || function (q) {
                        o = q;
                        b();
                        d();
                        A[j] = w;
                        try {
                            delete A[j]
                        } catch (p) {
                        }
                        z && z.removeChild(C)
                    }
            }
            if (e.dataType === "script" && e.cache === null)e.cache = false;
            if (e.cache ===
                false && n === "GET") {
                var r = J(), u = e.url.replace(wb, "$1_=" + r + "$2");
                e.url = u + (u === e.url ? (ka.test(e.url) ? "&" : "?") + "_=" + r : "")
            }
            if (e.data && n === "GET")e.url += (ka.test(e.url) ? "&" : "?") + e.data;
            e.global && !c.active++ && c.event.trigger("ajaxStart");
            r = (r = xb.exec(e.url)) && (r[1] && r[1] !== location.protocol || r[2] !== location.host);
            if (e.dataType === "script" && n === "GET" && r) {
                var z = s.getElementsByTagName("head")[0] || s.documentElement, C = s.createElement("script");
                C.src = e.url;
                if (e.scriptCharset)C.charset = e.scriptCharset;
                if (!j) {
                    var B =
                        false;
                    C.onload = C.onreadystatechange = function () {
                        if (!B && (!this.readyState || this.readyState === "loaded" || this.readyState === "complete")) {
                            B = true;
                            b();
                            d();
                            C.onload = C.onreadystatechange = null;
                            z && C.parentNode && z.removeChild(C)
                        }
                    }
                }
                z.insertBefore(C, z.firstChild);
                return w
            }
            var E = false, x = e.xhr();
            if (x) {
                e.username ? x.open(n, e.url, e.async, e.username, e.password) : x.open(n, e.url, e.async);
                try {
                    if (e.data || a && a.contentType)x.setRequestHeader("Content-Type", e.contentType);
                    if (e.ifModified) {
                        c.lastModified[e.url] && x.setRequestHeader("If-Modified-Since",
                            c.lastModified[e.url]);
                        c.etag[e.url] && x.setRequestHeader("If-None-Match", c.etag[e.url])
                    }
                    r || x.setRequestHeader("X-Requested-With", "XMLHttpRequest");
                    x.setRequestHeader("Accept", e.dataType && e.accepts[e.dataType] ? e.accepts[e.dataType] + ", */*" : e.accepts._default)
                } catch (ga) {
                }
                if (e.beforeSend && e.beforeSend.call(k, x, e) === false) {
                    e.global && !--c.active && c.event.trigger("ajaxStop");
                    x.abort();
                    return false
                }
                e.global && f("ajaxSend", [x, e]);
                var g = x.onreadystatechange = function (q) {
                    if (!x || x.readyState === 0 || q === "abort") {
                        E ||
                        d();
                        E = true;
                        if (x)x.onreadystatechange = c.noop
                    } else if (!E && x && (x.readyState === 4 || q === "timeout")) {
                        E = true;
                        x.onreadystatechange = c.noop;
                        i = q === "timeout" ? "timeout" : !c.httpSuccess(x) ? "error" : e.ifModified && c.httpNotModified(x, e.url) ? "notmodified" : "success";
                        var p;
                        if (i === "success")try {
                            o = c.httpData(x, e.dataType, e)
                        } catch (v) {
                            i = "parsererror";
                            p = v
                        }
                        if (i === "success" || i === "notmodified")j || b(); else c.handleError(e, x, i, p);
                        d();
                        q === "timeout" && x.abort();
                        if (e.async)x = null
                    }
                };
                try {
                    var h = x.abort;
                    x.abort = function () {
                        x && h.call(x);
                        g("abort")
                    }
                } catch (l) {
                }
                e.async && e.timeout > 0 && setTimeout(function () {
                    x && !E && g("timeout")
                }, e.timeout);
                try {
                    x.send(n === "POST" || n === "PUT" || n === "DELETE" ? e.data : null)
                } catch (m) {
                    c.handleError(e, x, null, m);
                    d()
                }
                e.async || g();
                return x
            }
        }, handleError: function (a, b, d, f) {
            if (a.error)a.error.call(a.context || a, b, d, f);
            if (a.global)(a.context ? c(a.context) : c.event).trigger("ajaxError", [b, a, f])
        }, active: 0, httpSuccess: function (a) {
            try {
                return !a.status && location.protocol === "file:" || a.status >= 200 && a.status < 300 || a.status === 304 || a.status ===
                    1223 || a.status === 0
            } catch (b) {
            }
            return false
        }, httpNotModified: function (a, b) {
            var d = a.getResponseHeader("Last-Modified"), f = a.getResponseHeader("Etag");
            if (d)c.lastModified[b] = d;
            if (f)c.etag[b] = f;
            return a.status === 304 || a.status === 0
        }, httpData: function (a, b, d) {
            var f = a.getResponseHeader("content-type") || "", e = b === "xml" || !b && f.indexOf("xml") >= 0;
            a = e ? a.responseXML : a.responseText;
            e && a.documentElement.nodeName === "parsererror" && c.error("parsererror");
            if (d && d.dataFilter)a = d.dataFilter(a, b);
            if (typeof a === "string")if (b ===
                "json" || !b && f.indexOf("json") >= 0)a = c.parseJSON(a); else if (b === "script" || !b && f.indexOf("javascript") >= 0)c.globalEval(a);
            return a
        }, param: function (a, b) {
            function d(i, o) {
                if (c.isArray(o))c.each(o, function (k, n) {
                    b || /\[\]$/.test(i) ? f(i, n) : d(i + "[" + (typeof n === "object" || c.isArray(n) ? k : "") + "]", n)
                }); else!b && o != null && typeof o === "object" ? c.each(o, function (k, n) {
                    d(i + "[" + k + "]", n)
                }) : f(i, o)
            }

            function f(i, o) {
                o = c.isFunction(o) ? o() : o;
                e[e.length] = encodeURIComponent(i) + "=" + encodeURIComponent(o)
            }

            var e = [];
            if (b === w)b = c.ajaxSettings.traditional;
            if (c.isArray(a) || a.jquery)c.each(a, function () {
                f(this.name, this.value)
            }); else for (var j in a)d(j, a[j]);
            return e.join("&").replace(yb, "+")
        }
    });
    var la = {}, Ab = /toggle|show|hide/, Bb = /^([+-]=)?([\d+-.]+)(.*)$/, W, va = [["height", "marginTop", "marginBottom", "paddingTop", "paddingBottom"], ["width", "marginLeft", "marginRight", "paddingLeft", "paddingRight"], ["opacity"]];
    c.fn.extend({
        show: function (a, b) {
            if (a || a === 0)return this.animate(K("show", 3), a, b); else {
                a = 0;
                for (b = this.length; a < b; a++) {
                    var d = c.data(this[a], "olddisplay");
                    this[a].style.display = d || "";
                    if (c.css(this[a], "display") === "none") {
                        d = this[a].nodeName;
                        var f;
                        if (la[d])f = la[d]; else {
                            var e = c("<" + d + " />").appendTo("body");
                            f = e.css("display");
                            if (f === "none")f = "block";
                            e.remove();
                            la[d] = f
                        }
                        c.data(this[a], "olddisplay", f)
                    }
                }
                a = 0;
                for (b = this.length; a < b; a++)this[a].style.display = c.data(this[a], "olddisplay") || "";
                return this
            }
        }, hide: function (a, b) {
            if (a || a === 0)return this.animate(K("hide", 3), a, b); else {
                a = 0;
                for (b = this.length; a < b; a++) {
                    var d = c.data(this[a], "olddisplay");
                    !d && d !== "none" && c.data(this[a],
                        "olddisplay", c.css(this[a], "display"))
                }
                a = 0;
                for (b = this.length; a < b; a++)this[a].style.display = "none";
                return this
            }
        }, _toggle: c.fn.toggle, toggle: function (a, b) {
            var d = typeof a === "boolean";
            if (c.isFunction(a) && c.isFunction(b))this._toggle.apply(this, arguments); else a == null || d ? this.each(function () {
                var f = d ? a : c(this).is(":hidden");
                c(this)[f ? "show" : "hide"]()
            }) : this.animate(K("toggle", 3), a, b);
            return this
        }, fadeTo: function (a, b, d) {
            return this.filter(":hidden").css("opacity", 0).show().end().animate({opacity: b}, a, d)
        },
        animate: function (a, b, d, f) {
            var e = c.speed(b, d, f);
            if (c.isEmptyObject(a))return this.each(e.complete);
            return this[e.queue === false ? "each" : "queue"](function () {
                var j = c.extend({}, e), i, o = this.nodeType === 1 && c(this).is(":hidden"), k = this;
                for (i in a) {
                    var n = i.replace(ia, ja);
                    if (i !== n) {
                        a[n] = a[i];
                        delete a[i];
                        i = n
                    }
                    if (a[i] === "hide" && o || a[i] === "show" && !o)return j.complete.call(this);
                    if ((i === "height" || i === "width") && this.style) {
                        j.display = c.css(this, "display");
                        j.overflow = this.style.overflow
                    }
                    if (c.isArray(a[i])) {
                        (j.specialEasing =
                            j.specialEasing || {})[i] = a[i][1];
                        a[i] = a[i][0]
                    }
                }
                if (j.overflow != null)this.style.overflow = "hidden";
                j.curAnim = c.extend({}, a);
                c.each(a, function (r, u) {
                    var z = new c.fx(k, j, r);
                    if (Ab.test(u))z[u === "toggle" ? o ? "show" : "hide" : u](a); else {
                        var C = Bb.exec(u), B = z.cur(true) || 0;
                        if (C) {
                            u = parseFloat(C[2]);
                            var E = C[3] || "px";
                            if (E !== "px") {
                                k.style[r] = (u || 1) + E;
                                B = (u || 1) / z.cur(true) * B;
                                k.style[r] = B + E
                            }
                            if (C[1])u = (C[1] === "-=" ? -1 : 1) * u + B;
                            z.custom(B, u, E)
                        } else z.custom(B, u, "")
                    }
                });
                return true
            })
        }, stop: function (a, b) {
            var d = c.timers;
            a && this.queue([]);
            this.each(function () {
                for (var f = d.length - 1; f >= 0; f--)if (d[f].elem === this) {
                    b && d[f](true);
                    d.splice(f, 1)
                }
            });
            b || this.dequeue();
            return this
        }
    });
    c.each({
        slideDown: K("show", 1),
        slideUp: K("hide", 1),
        slideToggle: K("toggle", 1),
        fadeIn: {opacity: "show"},
        fadeOut: {opacity: "hide"}
    }, function (a, b) {
        c.fn[a] = function (d, f) {
            return this.animate(b, d, f)
        }
    });
    c.extend({
        speed: function (a, b, d) {
            var f = a && typeof a === "object" ? a : {
                complete: d || !d && b || c.isFunction(a) && a,
                duration: a,
                easing: d && b || b && !c.isFunction(b) && b
            };
            f.duration = c.fx.off ? 0 : typeof f.duration ===
            "number" ? f.duration : c.fx.speeds[f.duration] || c.fx.speeds._default;
            f.old = f.complete;
            f.complete = function () {
                f.queue !== false && c(this).dequeue();
                c.isFunction(f.old) && f.old.call(this)
            };
            return f
        }, easing: {
            linear: function (a, b, d, f) {
                return d + f * a
            }, swing: function (a, b, d, f) {
                return (-Math.cos(a * Math.PI) / 2 + 0.5) * f + d
            }
        }, timers: [], fx: function (a, b, d) {
            this.options = b;
            this.elem = a;
            this.prop = d;
            if (!b.orig)b.orig = {}
        }
    });
    c.fx.prototype = {
        update: function () {
            this.options.step && this.options.step.call(this.elem, this.now, this);
            (c.fx.step[this.prop] ||
            c.fx.step._default)(this);
            if ((this.prop === "height" || this.prop === "width") && this.elem.style)this.elem.style.display = "block"
        }, cur: function (a) {
            if (this.elem[this.prop] != null && (!this.elem.style || this.elem.style[this.prop] == null))return this.elem[this.prop];
            return (a = parseFloat(c.css(this.elem, this.prop, a))) && a > -10000 ? a : parseFloat(c.curCSS(this.elem, this.prop)) || 0
        }, custom: function (a, b, d) {
            function f(j) {
                return e.step(j)
            }

            this.startTime = J();
            this.start = a;
            this.end = b;
            this.unit = d || this.unit || "px";
            this.now = this.start;
            this.pos = this.state = 0;
            var e = this;
            f.elem = this.elem;
            if (f() && c.timers.push(f) && !W)W = setInterval(c.fx.tick, 13)
        }, show: function () {
            this.options.orig[this.prop] = c.style(this.elem, this.prop);
            this.options.show = true;
            this.custom(this.prop === "width" || this.prop === "height" ? 1 : 0, this.cur());
            c(this.elem).show()
        }, hide: function () {
            this.options.orig[this.prop] = c.style(this.elem, this.prop);
            this.options.hide = true;
            this.custom(this.cur(), 0)
        }, step: function (a) {
            var b = J(), d = true;
            if (a || b >= this.options.duration + this.startTime) {
                this.now =
                    this.end;
                this.pos = this.state = 1;
                this.update();
                this.options.curAnim[this.prop] = true;
                for (var f in this.options.curAnim)if (this.options.curAnim[f] !== true)d = false;
                if (d) {
                    if (this.options.display != null) {
                        this.elem.style.overflow = this.options.overflow;
                        a = c.data(this.elem, "olddisplay");
                        this.elem.style.display = a ? a : this.options.display;
                        if (c.css(this.elem, "display") === "none")this.elem.style.display = "block"
                    }
                    this.options.hide && c(this.elem).hide();
                    if (this.options.hide || this.options.show)for (var e in this.options.curAnim)c.style(this.elem,
                        e, this.options.orig[e]);
                    this.options.complete.call(this.elem)
                }
                return false
            } else {
                e = b - this.startTime;
                this.state = e / this.options.duration;
                a = this.options.easing || (c.easing.swing ? "swing" : "linear");
                this.pos = c.easing[this.options.specialEasing && this.options.specialEasing[this.prop] || a](this.state, e, 0, 1, this.options.duration);
                this.now = this.start + (this.end - this.start) * this.pos;
                this.update()
            }
            return true
        }
    };
    c.extend(c.fx, {
        tick: function () {
            for (var a = c.timers, b = 0; b < a.length; b++)a[b]() || a.splice(b--, 1);
            a.length ||
            c.fx.stop()
        }, stop: function () {
            clearInterval(W);
            W = null
        }, speeds: {slow: 600, fast: 200, _default: 400}, step: {
            opacity: function (a) {
                c.style(a.elem, "opacity", a.now)
            }, _default: function (a) {
                if (a.elem.style && a.elem.style[a.prop] != null)a.elem.style[a.prop] = (a.prop === "width" || a.prop === "height" ? Math.max(0, a.now) : a.now) + a.unit; else a.elem[a.prop] = a.now
            }
        }
    });
    if (c.expr && c.expr.filters)c.expr.filters.animated = function (a) {
        return c.grep(c.timers, function (b) {
            return a === b.elem
        }).length
    };
    c.fn.offset = "getBoundingClientRect" in s.documentElement ?
        function (a) {
            var b = this[0];
            if (a)return this.each(function (e) {
                c.offset.setOffset(this, a, e)
            });
            if (!b || !b.ownerDocument)return null;
            if (b === b.ownerDocument.body)return c.offset.bodyOffset(b);
            var d = b.getBoundingClientRect(), f = b.ownerDocument;
            b = f.body;
            f = f.documentElement;
            return {
                top: d.top + (self.pageYOffset || c.support.boxModel && f.scrollTop || b.scrollTop) - (f.clientTop || b.clientTop || 0),
                left: d.left + (self.pageXOffset || c.support.boxModel && f.scrollLeft || b.scrollLeft) - (f.clientLeft || b.clientLeft || 0)
            }
        } : function (a) {
        var b =
            this[0];
        if (a)return this.each(function (r) {
            c.offset.setOffset(this, a, r)
        });
        if (!b || !b.ownerDocument)return null;
        if (b === b.ownerDocument.body)return c.offset.bodyOffset(b);
        c.offset.initialize();
        var d = b.offsetParent, f = b, e = b.ownerDocument, j, i = e.documentElement, o = e.body;
        f = (e = e.defaultView) ? e.getComputedStyle(b, null) : b.currentStyle;
        for (var k = b.offsetTop, n = b.offsetLeft; (b = b.parentNode) && b !== o && b !== i;) {
            if (c.offset.supportsFixedPosition && f.position === "fixed")break;
            j = e ? e.getComputedStyle(b, null) : b.currentStyle;
            k -= b.scrollTop;
            n -= b.scrollLeft;
            if (b === d) {
                k += b.offsetTop;
                n += b.offsetLeft;
                if (c.offset.doesNotAddBorder && !(c.offset.doesAddBorderForTableAndCells && /^t(able|d|h)$/i.test(b.nodeName))) {
                    k += parseFloat(j.borderTopWidth) || 0;
                    n += parseFloat(j.borderLeftWidth) || 0
                }
                f = d;
                d = b.offsetParent
            }
            if (c.offset.subtractsBorderForOverflowNotVisible && j.overflow !== "visible") {
                k += parseFloat(j.borderTopWidth) || 0;
                n += parseFloat(j.borderLeftWidth) || 0
            }
            f = j
        }
        if (f.position === "relative" || f.position === "static") {
            k += o.offsetTop;
            n += o.offsetLeft
        }
        if (c.offset.supportsFixedPosition &&
            f.position === "fixed") {
            k += Math.max(i.scrollTop, o.scrollTop);
            n += Math.max(i.scrollLeft, o.scrollLeft)
        }
        return {top: k, left: n}
    };
    c.offset = {
        initialize: function () {
            var a = s.body, b = s.createElement("div"), d, f, e, j = parseFloat(c.curCSS(a, "marginTop", true)) || 0;
            c.extend(b.style, {
                position: "absolute",
                top: 0,
                left: 0,
                margin: 0,
                border: 0,
                width: "1px",
                height: "1px",
                visibility: "hidden"
            });
            b.innerHTML = "<div style='position:absolute;top:0;left:0;margin:0;border:5px solid #000;padding:0;width:1px;height:1px;'><div></div></div><table style='position:absolute;top:0;left:0;margin:0;border:5px solid #000;padding:0;width:1px;height:1px;' cellpadding='0' cellspacing='0'><tr><td></td></tr></table>";
            a.insertBefore(b, a.firstChild);
            d = b.firstChild;
            f = d.firstChild;
            e = d.nextSibling.firstChild.firstChild;
            this.doesNotAddBorder = f.offsetTop !== 5;
            this.doesAddBorderForTableAndCells = e.offsetTop === 5;
            f.style.position = "fixed";
            f.style.top = "20px";
            this.supportsFixedPosition = f.offsetTop === 20 || f.offsetTop === 15;
            f.style.position = f.style.top = "";
            d.style.overflow = "hidden";
            d.style.position = "relative";
            this.subtractsBorderForOverflowNotVisible = f.offsetTop === -5;
            this.doesNotIncludeMarginInBodyOffset = a.offsetTop !== j;
            a.removeChild(b);
            c.offset.initialize = c.noop
        }, bodyOffset: function (a) {
            var b = a.offsetTop, d = a.offsetLeft;
            c.offset.initialize();
            if (c.offset.doesNotIncludeMarginInBodyOffset) {
                b += parseFloat(c.curCSS(a, "marginTop", true)) || 0;
                d += parseFloat(c.curCSS(a, "marginLeft", true)) || 0
            }
            return {top: b, left: d}
        }, setOffset: function (a, b, d) {
            if (/static/.test(c.curCSS(a, "position")))a.style.position = "relative";
            var f = c(a), e = f.offset(), j = parseInt(c.curCSS(a, "top", true), 10) || 0, i = parseInt(c.curCSS(a, "left", true), 10) || 0;
            if (c.isFunction(b))b = b.call(a,
                d, e);
            d = {top: b.top - e.top + j, left: b.left - e.left + i};
            "using" in b ? b.using.call(a, d) : f.css(d)
        }
    };
    c.fn.extend({
        position: function () {
            if (!this[0])return null;
            var a = this[0], b = this.offsetParent(), d = this.offset(), f = /^body|html$/i.test(b[0].nodeName) ? {
                top: 0,
                left: 0
            } : b.offset();
            d.top -= parseFloat(c.curCSS(a, "marginTop", true)) || 0;
            d.left -= parseFloat(c.curCSS(a, "marginLeft", true)) || 0;
            f.top += parseFloat(c.curCSS(b[0], "borderTopWidth", true)) || 0;
            f.left += parseFloat(c.curCSS(b[0], "borderLeftWidth", true)) || 0;
            return {
                top: d.top -
                f.top, left: d.left - f.left
            }
        }, offsetParent: function () {
            return this.map(function () {
                for (var a = this.offsetParent || s.body; a && !/^body|html$/i.test(a.nodeName) && c.css(a, "position") === "static";)a = a.offsetParent;
                return a
            })
        }
    });
    c.each(["Left", "Top"], function (a, b) {
        var d = "scroll" + b;
        c.fn[d] = function (f) {
            var e = this[0], j;
            if (!e)return null;
            if (f !== w)return this.each(function () {
                if (j = wa(this))j.scrollTo(!a ? f : c(j).scrollLeft(), a ? f : c(j).scrollTop()); else this[d] = f
            }); else return (j = wa(e)) ? "pageXOffset" in j ? j[a ? "pageYOffset" :
                "pageXOffset"] : c.support.boxModel && j.document.documentElement[d] || j.document.body[d] : e[d]
        }
    });
    c.each(["Height", "Width"], function (a, b) {
        var d = b.toLowerCase();
        c.fn["inner" + b] = function () {
            return this[0] ? c.css(this[0], d, false, "padding") : null
        };
        c.fn["outer" + b] = function (f) {
            return this[0] ? c.css(this[0], d, false, f ? "margin" : "border") : null
        };
        c.fn[d] = function (f) {
            var e = this[0];
            if (!e)return f == null ? null : this;
            if (c.isFunction(f))return this.each(function (j) {
                var i = c(this);
                i[d](f.call(this, j, i[d]()))
            });
            return "scrollTo" in
            e && e.document ? e.document.compatMode === "CSS1Compat" && e.document.documentElement["client" + b] || e.document.body["client" + b] : e.nodeType === 9 ? Math.max(e.documentElement["client" + b], e.body["scroll" + b], e.documentElement["scroll" + b], e.body["offset" + b], e.documentElement["offset" + b]) : f === w ? c.css(e, d) : this.css(d, typeof f === "string" ? f : f + "px")
        }
    });
    A.jQuery = A.$ = c
})(window);
/*
 * jQuery Form Plugin
 * version: 2.33 (22-SEP-2009)
 * @requires jQuery v1.2.6 or later
 *
 * Examples and documentation at: http://malsup.com/jquery/form/
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */
;(function ($) {

    /*
     Usage Note:
     -----------
     Do not use both ajaxSubmit and ajaxForm on the same form.  These
     functions are intended to be exclusive.  Use ajaxSubmit if you want
     to bind your own submit handler to the form.  For example,

     $(document).ready(function() {
     $('#myForm').bind('submit', function() {
     $(this).ajaxSubmit({
     target: '#output'
     });
     return false; // <-- important!
     });
     });

     Use ajaxForm when you want the plugin to manage all the event binding
     for you.  For example,

     $(document).ready(function() {
     $('#myForm').ajaxForm({
     target: '#output'
     });
     });

     When using ajaxForm, the ajaxSubmit function will be invoked for you
     at the appropriate time.
     */

    /**
     * ajaxSubmit() provides a mechanism for immediately submitting
     * an HTML form using AJAX.
     */
    $.fn.ajaxSubmit = function (options) {
        // fast fail if nothing selected (http://dev.jquery.com/ticket/2752)
        if (!this.length) {
            log('ajaxSubmit: skipping submit process - no element selected');
            return this;
        }

        if (typeof options == 'function')
            options = {success: options};

        var url = $.trim(this.attr('action'));
        if (url) {
            // clean url (don't include hash vaue)
            url = (url.match(/^([^#]+)/) || [])[1];
        }
        url = url || window.location.href || '';

        options = $.extend({
            url: url,
            type: this.attr('method') || 'GET'
        }, options || {});

        // hook for manipulating the form data before it is extracted;
        // convenient for use with rich editors like tinyMCE or FCKEditor
        var veto = {};
        this.trigger('form-pre-serialize', [this, options, veto]);
        if (veto.veto) {
            log('ajaxSubmit: submit vetoed via form-pre-serialize trigger');
            return this;
        }

        // provide opportunity to alter form data before it is serialized
        if (options.beforeSerialize && options.beforeSerialize(this, options) === false) {
            log('ajaxSubmit: submit aborted via beforeSerialize callback');
            return this;
        }

        var a = this.formToArray(options.semantic);
        if (options.data) {
            options.extraData = options.data;
            for (var n in options.data) {
                if (options.data[n] instanceof Array) {
                    for (var k in options.data[n])
                        a.push({name: n, value: options.data[n][k]});
                }
                else
                    a.push({name: n, value: options.data[n]});
            }
        }

        // give pre-submit callback an opportunity to abort the submit
        if (options.beforeSubmit && options.beforeSubmit(a, this, options) === false) {
            log('ajaxSubmit: submit aborted via beforeSubmit callback');
            return this;
        }

        // fire vetoable 'validate' event
        this.trigger('form-submit-validate', [a, this, options, veto]);
        if (veto.veto) {
            log('ajaxSubmit: submit vetoed via form-submit-validate trigger');
            return this;
        }

        var q = $.param(a);

        if (options.type.toUpperCase() == 'GET') {
            options.url += (options.url.indexOf('?') >= 0 ? '&' : '?') + q;
            options.data = null;  // data is null for 'get'
        }
        else
            options.data = q; // data is the query string for 'post'

        var $form = this, callbacks = [];
        if (options.resetForm) callbacks.push(function () {
            $form.resetForm();
        });
        if (options.clearForm) callbacks.push(function () {
            $form.clearForm();
        });

        // perform a load on the target only if dataType is not provided
        if (!options.dataType && options.target) {
            var oldSuccess = options.success || function () {
                };
            callbacks.push(function (data) {
                $(options.target).html(data).each(oldSuccess, arguments);
            });
        }
        else if (options.success)
            callbacks.push(options.success);

        options.success = function (data, status) {
            for (var i = 0, max = callbacks.length; i < max; i++)
                callbacks[i].apply(options, [data, status, $form]);
        };

        // are there files to upload?
        var files = $('input:file', this).fieldValue();
        var found = false;
        for (var j = 0; j < files.length; j++)
            if (files[j])
                found = true;

        var multipart = false;
//	var mp = 'multipart/form-data';
//	multipart = ($form.attr('enctype') == mp || $form.attr('encoding') == mp);

        // options.iframe allows user to force iframe mode
        if (options.iframe || found || multipart) {
            // hack to fix Safari hang (thanks to Tim Molendijk for this)
            // see:  http://groups.google.com/group/jquery-dev/browse_thread/thread/36395b7ab510dd5d
            if (options.closeKeepAlive)
                $.get(options.closeKeepAlive, fileUpload);
            else
                fileUpload();
        }
        else
            $.ajax(options);

        // fire 'notify' event
        this.trigger('form-submit-notify', [this, options]);
        return this;


        // private function for handling file uploads (hat tip to YAHOO!)
        function fileUpload() {
            var form = $form[0];

            if ($(':input[name=submit]', form).length) {
                alert('Error: Form elements must not be named "submit".');
                return;
            }

            var opts = $.extend({}, $.ajaxSettings, options);
            var s = $.extend(true, {}, $.extend(true, {}, $.ajaxSettings), opts);

            var id = 'jqFormIO' + (new Date().getTime());
            var $io = $('<iframe id="' + id + '" name="' + id + '" src="about:blank" />');
            var io = $io[0];

            $io.css({position: 'absolute', top: '-1000px', left: '-1000px'});

            var xhr = { // mock object
                aborted: 0,
                responseText: null,
                responseXML: null,
                status: 0,
                statusText: 'n/a',
                getAllResponseHeaders: function () {
                },
                getResponseHeader: function () {
                },
                setRequestHeader: function () {
                },
                abort: function () {
                    this.aborted = 1;
                    $io.attr('src', 'about:blank'); // abort op in progress
                }
            };

            var g = opts.global;
            // trigger ajax global events so that activity/block indicators work like normal
            if (g && !$.active++) $.event.trigger("ajaxStart");
            if (g) $.event.trigger("ajaxSend", [xhr, opts]);

            if (s.beforeSend && s.beforeSend(xhr, s) === false) {
                s.global && $.active--;
                return;
            }
            if (xhr.aborted)
                return;

            var cbInvoked = 0;
            var timedOut = 0;

            // add submitting element to data if we know it
            var sub = form.clk;
            if (sub) {
                var n = sub.name;
                if (n && !sub.disabled) {
                    options.extraData = options.extraData || {};
                    options.extraData[n] = sub.value;
                    if (sub.type == "image") {
                        options.extraData[name + '.x'] = form.clk_x;
                        options.extraData[name + '.y'] = form.clk_y;
                    }
                }
            }

            // take a breath so that pending repaints get some cpu time before the upload starts
            setTimeout(function () {
                // make sure form attrs are set
                var t = $form.attr('target'), a = $form.attr('action');

                // update form attrs in IE friendly way
                form.setAttribute('target', id);
                if (form.getAttribute('method') != 'POST')
                    form.setAttribute('method', 'POST');
                if (form.getAttribute('action') != opts.url)
                    form.setAttribute('action', opts.url);

                // ie borks in some cases when setting encoding
                if (!options.skipEncodingOverride) {
                    $form.attr({
                        encoding: 'multipart/form-data',
                        enctype: 'multipart/form-data'
                    });
                }

                // support timout
                if (opts.timeout)
                    setTimeout(function () {
                        timedOut = true;
                        cb();
                    }, opts.timeout);

                // add "extra" data to form if provided in options
                var extraInputs = [];
                try {
                    if (options.extraData)
                        for (var n in options.extraData)
                            extraInputs.push(
                                $('<input type="hidden" name="' + n + '" value="' + options.extraData[n] + '" />')
                                    .appendTo(form)[0]);

                    // add iframe to doc and submit the form
                    $io.appendTo('body');
                    io.attachEvent ? io.attachEvent('onload', cb) : io.addEventListener('load', cb, false);
                    form.submit();
                }
                finally {
                    // reset attrs and remove "extra" input elements
                    form.setAttribute('action', a);
                    t ? form.setAttribute('target', t) : $form.removeAttr('target');
                    $(extraInputs).remove();
                }
            }, 10);

            var domCheckCount = 50;

            function cb() {
                if (cbInvoked++) return;

                io.detachEvent ? io.detachEvent('onload', cb) : io.removeEventListener('load', cb, false);

                var ok = true;
                try {
                    if (timedOut) throw 'timeout';
                    // extract the server response from the iframe
                    var data, doc;

                    doc = io.contentWindow ? io.contentWindow.document : io.contentDocument ? io.contentDocument : io.document;

                    var isXml = opts.dataType == 'xml' || doc.XMLDocument || $.isXMLDoc(doc);
                    log('isXml=' + isXml);
                    if (!isXml && (doc.body == null || doc.body.innerHTML == '')) {
                        if (--domCheckCount) {
                            // in some browsers (Opera) the iframe DOM is not always traversable when
                            // the onload callback fires, so we loop a bit to accommodate
                            cbInvoked = 0;
                            setTimeout(cb, 100);
                            return;
                        }
                        log('Could not access iframe DOM after 50 tries.');
                        return;
                    }

                    xhr.responseText = doc.body ? doc.body.innerHTML : null;
                    xhr.responseXML = doc.XMLDocument ? doc.XMLDocument : doc;
                    xhr.getResponseHeader = function (header) {
                        var headers = {'content-type': opts.dataType};
                        return headers[header];
                    };

                    if (opts.dataType == 'json' || opts.dataType == 'script') {
                        // see if user embedded response in textarea
                        var ta = doc.getElementsByTagName('textarea')[0];
                        if (ta)
                            xhr.responseText = ta.value;
                        else {
                            // account for browsers injecting pre around json response
                            var pre = doc.getElementsByTagName('pre')[0];
                            if (pre)
                                xhr.responseText = pre.innerHTML;
                        }
                    }
                    else if (opts.dataType == 'xml' && !xhr.responseXML && xhr.responseText != null) {
                        xhr.responseXML = toXml(xhr.responseText);
                    }
                    data = $.httpData(xhr, opts.dataType);
                }
                catch (e) {
                    ok = false;
                    $.handleError(opts, xhr, 'error', e);
                }

                // ordering of these callbacks/triggers is odd, but that's how $.ajax does it
                if (ok) {
                    opts.success(data, 'success');
                    if (g) $.event.trigger("ajaxSuccess", [xhr, opts]);
                }
                if (g) $.event.trigger("ajaxComplete", [xhr, opts]);
                if (g && !--$.active) $.event.trigger("ajaxStop");
                if (opts.complete) opts.complete(xhr, ok ? 'success' : 'error');

                // clean up
                setTimeout(function () {
                    $io.remove();
                    xhr.responseXML = null;
                }, 100);
            };

            function toXml(s, doc) {
                if (window.ActiveXObject) {
                    doc = new ActiveXObject('Microsoft.XMLDOM');
                    doc.async = 'false';
                    doc.loadXML(s);
                }
                else
                    doc = (new DOMParser()).parseFromString(s, 'text/xml');
                return (doc && doc.documentElement && doc.documentElement.tagName != 'parsererror') ? doc : null;
            };
        };
    };

    /**
     * ajaxForm() provides a mechanism for fully automating form submission.
     *
     * The advantages of using this method instead of ajaxSubmit() are:
     *
     * 1: This method will include coordinates for <input type="image" /> elements (if the element
     *    is used to submit the form).
     * 2. This method will include the submit element's name/value data (for the element that was
     *    used to submit the form).
     * 3. This method binds the submit() method to the form for you.
     *
     * The options argument for ajaxForm works exactly as it does for ajaxSubmit.  ajaxForm merely
     * passes the options argument along after properly binding events for submit elements and
     * the form itself.
     */
    $.fn.ajaxForm = function (options) {
        return this.ajaxFormUnbind().bind('submit.form-plugin', function () {
            $(this).ajaxSubmit(options);
            return false;
        }).bind('click.form-plugin', function (e) {
            var $el = $(e.target);
            if (!($el.is(":submit,input:image"))) {
                return;
            }
            var form = this;
            form.clk = e.target;
            if (e.target.type == 'image') {
                if (e.offsetX != undefined) {
                    form.clk_x = e.offsetX;
                    form.clk_y = e.offsetY;
                } else if (typeof $.fn.offset == 'function') { // try to use dimensions plugin
                    var offset = $el.offset();
                    form.clk_x = e.pageX - offset.left;
                    form.clk_y = e.pageY - offset.top;
                } else {
                    form.clk_x = e.pageX - e.target.offsetLeft;
                    form.clk_y = e.pageY - e.target.offsetTop;
                }
            }
            // clear form vars
            setTimeout(function () {
                form.clk = form.clk_x = form.clk_y = null;
            }, 10);
        });
    };

// ajaxFormUnbind unbinds the event handlers that were bound by ajaxForm
    $.fn.ajaxFormUnbind = function () {
        return this.unbind('submit.form-plugin click.form-plugin');
    };

    /**
     * formToArray() gathers form element data into an array of objects that can
     * be passed to any of the following ajax functions: $.get, $.post, or load.
     * Each object in the array has both a 'name' and 'value' property.  An example of
     * an array for a simple login form might be:
     *
     * [ { name: 'username', value: 'jresig' }, { name: 'password', value: 'secret' } ]
     *
     * It is this array that is passed to pre-submit callback functions provided to the
     * ajaxSubmit() and ajaxForm() methods.
     */
    $.fn.formToArray = function (semantic) {
        var a = [];
        if (this.length == 0) return a;

        var form = this[0];
        var els = semantic ? form.getElementsByTagName('*') : form.elements;
        if (!els) return a;
        for (var i = 0, max = els.length; i < max; i++) {
            var el = els[i];
            var n = el.name;
            if (!n) continue;

            if (semantic && form.clk && el.type == "image") {
                // handle image inputs on the fly when semantic == true
                if (!el.disabled && form.clk == el) {
                    a.push({name: n, value: $(el).val()});
                    a.push({name: n + '.x', value: form.clk_x}, {name: n + '.y', value: form.clk_y});
                }
                continue;
            }

            var v = $.fieldValue(el, true);
            if (v && v.constructor == Array) {
                for (var j = 0, jmax = v.length; j < jmax; j++)
                    a.push({name: n, value: v[j]});
            }
            else if (v !== null && typeof v != 'undefined')
                a.push({name: n, value: v});
        }

        if (!semantic && form.clk) {
            // input type=='image' are not found in elements array! handle it here
            var $input = $(form.clk), input = $input[0], n = input.name;
            if (n && !input.disabled && input.type == 'image') {
                a.push({name: n, value: $input.val()});
                a.push({name: n + '.x', value: form.clk_x}, {name: n + '.y', value: form.clk_y});
            }
        }
        return a;
    };

    /**
     * Serializes form data into a 'submittable' string. This method will return a string
     * in the format: name1=value1&amp;name2=value2
     */
    $.fn.formSerialize = function (semantic) {
        //hand off to jQuery.param for proper encoding
        return $.param(this.formToArray(semantic));
    };

    /**
     * Serializes all field elements in the jQuery object into a query string.
     * This method will return a string in the format: name1=value1&amp;name2=value2
     */
    $.fn.fieldSerialize = function (successful) {
        var a = [];
        this.each(function () {
            var n = this.name;
            if (!n) return;
            var v = $.fieldValue(this, successful);
            if (v && v.constructor == Array) {
                for (var i = 0, max = v.length; i < max; i++)
                    a.push({name: n, value: v[i]});
            }
            else if (v !== null && typeof v != 'undefined')
                a.push({name: this.name, value: v});
        });
        //hand off to jQuery.param for proper encoding
        return $.param(a);
    };

    /**
     * Returns the value(s) of the element in the matched set.  For example, consider the following form:
     *
     *  <form><fieldset>
     *      <input name="A" type="text" />
     *      <input name="A" type="text" />
     *      <input name="B" type="checkbox" value="B1" />
     *      <input name="B" type="checkbox" value="B2"/>
     *      <input name="C" type="radio" value="C1" />
     *      <input name="C" type="radio" value="C2" />
     *  </fieldset></form>
     *
     *  var v = $(':text').fieldValue();
     *  // if no values are entered into the text inputs
     *  v == ['','']
     *  // if values entered into the text inputs are 'foo' and 'bar'
     *  v == ['foo','bar']
     *
     *  var v = $(':checkbox').fieldValue();
     *  // if neither checkbox is checked
     *  v === undefined
     *  // if both checkboxes are checked
     *  v == ['B1', 'B2']
     *
     *  var v = $(':radio').fieldValue();
     *  // if neither radio is checked
     *  v === undefined
     *  // if first radio is checked
     *  v == ['C1']
     *
     * The successful argument controls whether or not the field element must be 'successful'
     * (per http://www.w3.org/TR/html4/interact/forms.html#successful-controls).
     * The default value of the successful argument is true.  If this value is false the value(s)
     * for each element is returned.
     *
     * Note: This method *always* returns an array.  If no valid value can be determined the
     *       array will be empty, otherwise it will contain one or more values.
     */
    $.fn.fieldValue = function (successful) {
        for (var val = [], i = 0, max = this.length; i < max; i++) {
            var el = this[i];
            var v = $.fieldValue(el, successful);
            if (v === null || typeof v == 'undefined' || (v.constructor == Array && !v.length))
                continue;
            v.constructor == Array ? $.merge(val, v) : val.push(v);
        }
        return val;
    };

    /**
     * Returns the value of the field element.
     */
    $.fieldValue = function (el, successful) {
        var n = el.name, t = el.type, tag = el.tagName.toLowerCase();
        if (typeof successful == 'undefined') successful = true;

        if (successful && (!n || el.disabled || t == 'reset' || t == 'button' ||
            (t == 'checkbox' || t == 'radio') && !el.checked ||
            (t == 'submit' || t == 'image') && el.form && el.form.clk != el ||
            tag == 'select' && el.selectedIndex == -1))
            return null;

        if (tag == 'select') {
            var index = el.selectedIndex;
            if (index < 0) return null;
            var a = [], ops = el.options;
            var one = (t == 'select-one');
            var max = (one ? index + 1 : ops.length);
            for (var i = (one ? index : 0); i < max; i++) {
                var op = ops[i];
                if (op.selected) {
                    var v = op.value;
                    if (!v) // extra pain for IE...
                        v = (op.attributes && op.attributes['value'] && !(op.attributes['value'].specified)) ? op.text : op.value;
                    if (one) return v;
                    a.push(v);
                }
            }
            return a;
        }
        return el.value;
    };

    /**
     * Clears the form data.  Takes the following actions on the form's input fields:
     *  - input text fields will have their 'value' property set to the empty string
     *  - select elements will have their 'selectedIndex' property set to -1
     *  - checkbox and radio inputs will have their 'checked' property set to false
     *  - inputs of type submit, button, reset, and hidden will *not* be effected
     *  - button elements will *not* be effected
     */
    $.fn.clearForm = function () {
        return this.each(function () {
            $('input,select,textarea', this).clearFields();
        });
    };

    /**
     * Clears the selected form elements.
     */
    $.fn.clearFields = $.fn.clearInputs = function () {
        return this.each(function () {
            var t = this.type, tag = this.tagName.toLowerCase();
            if (t == 'text' || t == 'password' || tag == 'textarea')
                this.value = '';
            else if (t == 'checkbox' || t == 'radio')
                this.checked = false;
            else if (tag == 'select')
                this.selectedIndex = -1;
        });
    };

    /**
     * Resets the form data.  Causes all form elements to be reset to their original value.
     */
    $.fn.resetForm = function () {
        return this.each(function () {
            // guard against an input with the name of 'reset'
            // note that IE reports the reset function as an 'object'
            if (typeof this.reset == 'function' || (typeof this.reset == 'object' && !this.reset.nodeType))
                this.reset();
        });
    };

    /**
     * Enables or disables any matching elements.
     */
    $.fn.enable = function (b) {
        if (b == undefined) b = true;
        return this.each(function () {
            this.disabled = !b;
        });
    };

    /**
     * Checks/unchecks any matching checkboxes or radio buttons and
     * selects/deselects and matching option elements.
     */
    $.fn.selected = function (select) {
        if (select == undefined) select = true;
        return this.each(function () {
            var t = this.type;
            if (t == 'checkbox' || t == 'radio')
                this.checked = select;
            else if (this.tagName.toLowerCase() == 'option') {
                var $sel = $(this).parent('select');
                if (select && $sel[0] && $sel[0].type == 'select-one') {
                    // deselect all other options
                    $sel.find('option').selected(false);
                }
                this.selected = select;
            }
        });
    };

// helper fn for console logging
// set $.fn.ajaxSubmit.debug to true to enable debug logging
    function log() {
        if ($.fn.ajaxSubmit.debug && window.console && window.console.log)
            window.console.log('[jquery.form] ' + Array.prototype.join.call(arguments, ''));
    };

})(jQuery);
/**
 * Boxy 0.1.4 - Facebook-style dialog, with frills
 *
 * (c) 2008 Jason Frame
 * Licensed under the MIT License (LICENSE)
 */

/*
 * jQuery plugin
 *
 * Options:
 *   message: confirmation message for form submit hook (default: "Please confirm:")
 * 
 * Any other options - e.g. 'clone' - will be passed onto the boxy constructor (or
 * Boxy.load for AJAX operations)
 */
jQuery.fn.boxy = function (options) {
    options = options || {};
    return this.each(function () {
        var node = this.nodeName.toLowerCase(), self = this;
        if (node == 'a') {
            jQuery(this).click(function () {
                var active = Boxy.linkedTo(this),
                    href = this.getAttribute('href'),
                    localOptions = jQuery.extend({actuator: this, title: this.title}, options);

                if (active) {
                    active.show();
                } else if (href.indexOf('#') >= 0) {
                    var content = jQuery(href.substr(href.indexOf('#'))),
                        newContent = content.clone(true);
                    content.remove();
                    localOptions.unloadOnHide = false;
                    new Boxy(newContent, localOptions);
                } else { // fall back to AJAX; could do with a same-origin check
                    if (!localOptions.cache) localOptions.unloadOnHide = true;
                    Boxy.load(this.href, localOptions);
                }

                return false;
            });
        } else if (node == 'form') {
            jQuery(this).bind('submit.boxy', function () {
                Boxy.confirm(options.message || 'Please confirm:', function () {
                    jQuery(self).unbind('submit.boxy').submit();
                });
                return false;
            });
        }
    });
};

//
// Boxy Class

function Boxy(element, options) {

    this.boxy = jQuery(Boxy.WRAPPER);
    jQuery.data(this.boxy[0], 'boxy', this);

    this.visible = false;
    this.options = jQuery.extend({}, Boxy.DEFAULTS, options || {});

    if (this.options.modal) {
        this.options = jQuery.extend(this.options, {center: true, draggable: false});
    }

    // options.actuator == DOM element that opened this boxy
    // association will be automatically deleted when this boxy is remove()d
    if (this.options.actuator) {
        jQuery.data(this.options.actuator, 'active.boxy', this);
    }

    this.setContent(element || "<div></div>");
    this._setupTitleBar();

    this.boxy.css('display', 'none').appendTo(document.body);
    this.toTop();

    if (this.options.fixed) {
        if (jQuery.browser.msie && jQuery.browser.version < 7) {
            this.options.fixed = false; // IE6 doesn't support fixed positioning
        } else {
            this.boxy.addClass('fixed');
        }
    }

    if (this.options.center && Boxy._u(this.options.x, this.options.y)) {
        this.center();
    } else {
        this.moveTo(
            Boxy._u(this.options.x) ? this.options.x : Boxy.DEFAULT_X,
            Boxy._u(this.options.y) ? this.options.y : Boxy.DEFAULT_Y
        );
    }

    if (this.options.show) this.show();

};

Boxy.EF = function () {
};

jQuery.extend(Boxy, {

    WRAPPER: "<table cellspacing='0' cellpadding='0' border='0' class='boxy-wrapper'>" +
    "<tr><td class='top-left'></td><td class='top'></td><td class='top-right'></td></tr>" +
    "<tr><td class='left'></td><td class='boxy-inner'></td><td class='right'></td></tr>" +
    "<tr><td class='bottom-left'></td><td class='bottom'></td><td class='bottom-right'></td></tr>" +
    "</table>",

    DEFAULTS: {
        title: null,           // titlebar text. titlebar will not be visible if not set.
        closeable: true,           // display close link in titlebar?
        draggable: true,           // can this dialog be dragged?
        clone: false,          // clone content prior to insertion into dialog?
        actuator: null,           // element which opened this dialog
        center: true,           // center dialog in viewport?
        show: true,           // show dialog immediately?
        modal: false,          // make dialog modal?
        fixed: true,           // use fixed positioning, if supported? absolute positioning used otherwise
        closeText: '[close]',      // text to use for default close link
        unloadOnHide: false,          // should this dialog be removed from the DOM after being hidden?
        clickToFront: false,          // bring dialog to foreground on any click (not just titlebar)?
        behaviours: Boxy.EF,        // function used to apply behaviours to all content embedded in dialog.
        afterDrop: Boxy.EF,        // callback fired after dialog is dropped. executes in context of Boxy instance.
        afterShow: Boxy.EF,        // callback fired after dialog becomes visible. executes in context of Boxy instance.
        afterHide: Boxy.EF,        // callback fired after dialog is hidden. executed in context of Boxy instance.
        beforeUnload: Boxy.EF         // callback fired after dialog is unloaded. executed in context of Boxy instance.
    },

    DEFAULT_X: 50,
    DEFAULT_Y: 50,
    zIndex: 1337,
    dragConfigured: false, // only set up one drag handler for all boxys
    resizeConfigured: false,
    dragging: null,

    // load a URL and display in boxy
    // url - url to load
    // options keys (any not listed below are passed to boxy constructor)
    //   type: HTTP method, default: GET
    //   cache: cache retrieved content? default: false
    //   filter: jQuery selector used to filter remote content
    load: function (url, options) {

        options = options || {};

        var ajax = {
            url: url, type: 'GET', dataType: 'html', cache: false, success: function (html) {
                html = jQuery(html);
                if (options.filter) html = jQuery(options.filter, html);
                new Boxy(html, options);
            }
        };

        jQuery.each(['type', 'cache'], function () {
            if (this in options) {
                ajax[this] = options[this];
                delete options[this];
            }
        });

        jQuery.ajax(ajax);

    },

    // allows you to get a handle to the containing boxy instance of any element
    // e.g. <a href='#' onclick='alert(Boxy.get(this));'>inspect!</a>.
    // this returns the actual instance of the boxy 'class', not just a DOM element.
    // Boxy.get(this).hide() would be valid, for instance.
    get: function (ele) {
        var p = jQuery(ele).parents('.boxy-wrapper');
        return p.length ? jQuery.data(p[0], 'boxy') : null;
    },

    // returns the boxy instance which has been linked to a given element via the
    // 'actuator' constructor option.
    linkedTo: function (ele) {
        return jQuery.data(ele, 'active.boxy');
    },

    // displays an alert box with a given message, calling optional callback
    // after dismissal.
    alert: function (message, callback, options) {
        return Boxy.ask(message, ['OK'], callback, options);
    },

    // displays an alert box with a given message, calling after callback iff
    // user selects OK.
    confirm: function (message, after, options) {
        return Boxy.ask(message, ['OK', 'Cancel'], function (response) {
            if (response == 'OK') after();
        }, options);
    },

    // asks a question with multiple responses presented as buttons
    // selected item is returned to a callback method.
    // answers may be either an array or a hash. if it's an array, the
    // the callback will received the selected value. if it's a hash,
    // you'll get the corresponding key.
    ask: function (question, answers, callback, options) {

        options = jQuery.extend({modal: true, closeable: false},
            options || {},
            {show: true, unloadOnHide: true});

        var body = jQuery('<div></div>').append(jQuery('<div class="question"></div>').html(question));

        // ick
        var map = {}, answerStrings = [];
        if (answers instanceof Array) {
            for (var i = 0; i < answers.length; i++) {
                map[answers[i]] = answers[i];
                answerStrings.push(answers[i]);
            }
        } else {
            for (var k in answers) {
                map[answers[k]] = k;
                answerStrings.push(answers[k]);
            }
        }

        var buttons = jQuery('<form class="answers"></form>');
        buttons.html(jQuery.map(answerStrings, function (v) {
            return "<input type='button' value='" + v + "' />";
        }).join(' '));

        jQuery('input[type=button]', buttons).click(function () {
            var clicked = this;
            Boxy.get(this).hide(function () {
                if (callback) callback(map[clicked.value]);
            });
        });

        body.append(buttons);

        new Boxy(body, options);

    },

    // returns true if a modal boxy is visible, false otherwise
    isModalVisible: function () {
        return jQuery('.boxy-modal-blackout').length > 0;
    },

    _u: function () {
        for (var i = 0; i < arguments.length; i++)
            if (typeof arguments[i] != 'undefined') return false;
        return true;
    },

    _handleResize: function (evt) {
        var d = jQuery(document);
        jQuery('.boxy-modal-blackout').css('display', 'none').css({
            width: d.width(), height: d.height()
        }).css('display', 'block');
    },

    _handleDrag: function (evt) {
        var d;
        if (d = Boxy.dragging) {
            d[0].boxy.css({left: evt.pageX - d[1], top: evt.pageY - d[2]});
        }
    },

    _nextZ: function () {
        return Boxy.zIndex++;
    },

    _viewport: function () {
        var d = document.documentElement, b = document.body, w = window;
        return jQuery.extend(
            jQuery.browser.msie ?
            {left: b.scrollLeft || d.scrollLeft, top: b.scrollTop || d.scrollTop} :
            {left: w.pageXOffset, top: w.pageYOffset},
            !Boxy._u(w.innerWidth) ?
            {width: w.innerWidth, height: w.innerHeight} :
                (!Boxy._u(d) && !Boxy._u(d.clientWidth) && d.clientWidth != 0 ?
                {width: d.clientWidth, height: d.clientHeight} :
                {width: b.clientWidth, height: b.clientHeight}));
    }

});

Boxy.prototype = {

    // Returns the size of this boxy instance without displaying it.
    // Do not use this method if boxy is already visible, use getSize() instead.
    estimateSize: function () {
        this.boxy.css({visibility: 'hidden', display: 'block'});
        var dims = this.getSize();
        this.boxy.css('display', 'none').css('visibility', 'visible');
        return dims;
    },

    // Returns the dimensions of the entire boxy dialog as [width,height]
    getSize: function () {
        return [this.boxy.width(), this.boxy.height()];
    },

    // Returns the dimensions of the content region as [width,height]
    getContentSize: function () {
        var c = this.getContent();
        return [c.width(), c.height()];
    },

    // Returns the position of this dialog as [x,y]
    getPosition: function () {
        var b = this.boxy[0];
        return [b.offsetLeft, b.offsetTop];
    },

    // Returns the center point of this dialog as [x,y]
    getCenter: function () {
        var p = this.getPosition();
        var s = this.getSize();
        return [Math.floor(p[0] + s[0] / 2), Math.floor(p[1] + s[1] / 2)];
    },

    // Returns a jQuery object wrapping the inner boxy region.
    // Not much reason to use this, you're probably more interested in getContent()
    getInner: function () {
        return jQuery('.boxy-inner', this.boxy);
    },

    // Returns a jQuery object wrapping the boxy content region.
    // This is the user-editable content area (i.e. excludes titlebar)
    getContent: function () {
        return jQuery('.boxy-content', this.boxy);
    },

    // Replace dialog content
    setContent: function (newContent) {
        newContent = jQuery(newContent).css({display: 'block'}).addClass('boxy-content');
        if (this.options.clone) newContent = newContent.clone(true);
        this.getContent().remove();
        this.getInner().append(newContent);
        this._setupDefaultBehaviours(newContent);
        this.options.behaviours.call(this, newContent);
        return this;
    },

    // Move this dialog to some position, funnily enough
    moveTo: function (x, y) {
        this.moveToX(x).moveToY(y);
        return this;
    },

    // Move this dialog (x-coord only)
    moveToX: function (x) {
        if (typeof x == 'number') this.boxy.css({left: x});
        else this.centerX();
        return this;
    },

    // Move this dialog (y-coord only)
    moveToY: function (y) {
        if (typeof y == 'number') this.boxy.css({top: y});
        else this.centerY();
        return this;
    },

    // Move this dialog so that it is centered at (x,y)
    centerAt: function (x, y) {
        var s = this[this.visible ? 'getSize' : 'estimateSize']();
        if (typeof x == 'number') this.moveToX(x - s[0] / 2);
        if (typeof y == 'number') this.moveToY(y - s[1] / 2);
        return this;
    },

    centerAtX: function (x) {
        return this.centerAt(x, null);
    },

    centerAtY: function (y) {
        return this.centerAt(null, y);
    },

    // Center this dialog in the viewport
    // axis is optional, can be 'x', 'y'.
    center: function (axis) {
        var v = Boxy._viewport();
        var o = this.options.fixed ? [0, 0] : [v.left, v.top];
        if (!axis || axis == 'x') this.centerAt(o[0] + v.width / 2, null);
        if (!axis || axis == 'y') this.centerAt(null, o[1] + v.height / 2);
        return this;
    },

    // Center this dialog in the viewport (x-coord only)
    centerX: function () {
        return this.center('x');
    },

    // Center this dialog in the viewport (y-coord only)
    centerY: function () {
        return this.center('y');
    },

    // Resize the content region to a specific size
    resize: function (width, height, after) {
        if (!this.visible) return;
        var bounds = this._getBoundsForResize(width, height);
        this.boxy.css({left: bounds[0], top: bounds[1]});
        this.getContent().css({width: bounds[2], height: bounds[3]});
        if (after) after(this);
        return this;
    },

    // Tween the content region to a specific size
    tween: function (width, height, after) {
        if (!this.visible) return;
        var bounds = this._getBoundsForResize(width, height);
        var self = this;
        this.boxy.stop().animate({left: bounds[0], top: bounds[1]});
        this.getContent().stop().animate({width: bounds[2], height: bounds[3]}, function () {
            if (after) after(self);
        });
        return this;
    },

    // Returns true if this dialog is visible, false otherwise
    isVisible: function () {
        return this.visible;
    },

    // Make this boxy instance visible
    show: function () {
        if (this.visible) return;
        if (this.options.modal) {
            var self = this;
            if (!Boxy.resizeConfigured) {
                Boxy.resizeConfigured = true;
                jQuery(window).resize(function () {
                    Boxy._handleResize();
                });
            }
            this.modalBlackout = jQuery('<div class="boxy-modal-blackout"></div>')
                .css({
                    zIndex: Boxy._nextZ(),
                    opacity: 0.7,
                    width: jQuery(document).width(),
                    height: jQuery(document).height()
                })
                .appendTo(document.body);
            this.toTop();
            if (this.options.closeable) {
                jQuery(document.body).bind('keypress.boxy', function (evt) {
                    var key = evt.which || evt.keyCode;
                    if (key == 27) {
                        self.hide();
                        jQuery(document.body).unbind('keypress.boxy');
                    }
                });
            }
        }
        this.boxy.stop().css({opacity: 1}).show();
        this.visible = true;
        this._fire('afterShow');
        return this;
    },

    // Hide this boxy instance
    hide: function (after) {
        if (!this.visible) return;
        var self = this;
        if (this.options.modal) {
            jQuery(document.body).unbind('keypress.boxy');
            this.modalBlackout.animate({opacity: 0}, function () {
                jQuery(this).remove();
            });
        }
        this.boxy.stop().animate({opacity: 0}, 300, function () {
            self.boxy.css({display: 'none'});
            self.visible = false;
            self._fire('afterHide');
            if (after) after(self);
            if (self.options.unloadOnHide) self.unload();
        });
        return this;
    },

    toggle: function () {
        this[this.visible ? 'hide' : 'show']();
        return this;
    },

    hideAndUnload: function (after) {
        this.options.unloadOnHide = true;
        this.hide(after);
        return this;
    },

    unload: function () {
        this._fire('beforeUnload');
        this.boxy.remove();
        if (this.options.actuator) {
            jQuery.data(this.options.actuator, 'active.boxy', false);
        }
    },

    // Move this dialog box above all other boxy instances
    toTop: function () {
        this.boxy.css({zIndex: Boxy._nextZ()});
        return this;
    },

    // Returns the title of this dialog
    getTitle: function () {
        return jQuery('> .title-bar h2', this.getInner()).html();
    },

    // Sets the title of this dialog
    setTitle: function (t) {
        jQuery('> .title-bar h2', this.getInner()).html(t);
        return this;
    },

    //
    // Don't touch these privates

    _getBoundsForResize: function (width, height) {
        var csize = this.getContentSize();
        var delta = [width - csize[0], height - csize[1]];
        var p = this.getPosition();
        return [Math.max(p[0] - delta[0] / 2, 0),
            Math.max(p[1] - delta[1] / 2, 0), width, height];
    },

    _setupTitleBar: function () {
        if (this.options.title) {
            var self = this;
            var tb = jQuery("<div class='title-bar'></div>").html("<h2>" + this.options.title + "</h2>");
            if (this.options.closeable) {
                tb.append(jQuery("<a href='#' class='close'></a>").html(this.options.closeText));
            }
            if (this.options.draggable) {
                tb[0].onselectstart = function () {
                    return false;
                }
                tb[0].unselectable = 'on';
                tb[0].style.MozUserSelect = 'none';
                if (!Boxy.dragConfigured) {
                    jQuery(document).mousemove(Boxy._handleDrag);
                    Boxy.dragConfigured = true;
                }
                tb.mousedown(function (evt) {
                    self.toTop();
                    Boxy.dragging = [self, evt.pageX - self.boxy[0].offsetLeft, evt.pageY - self.boxy[0].offsetTop];
                    jQuery(this).addClass('dragging');
                }).mouseup(function () {
                    jQuery(this).removeClass('dragging');
                    Boxy.dragging = null;
                    self._fire('afterDrop');
                });
            }
            this.getInner().prepend(tb);
            this._setupDefaultBehaviours(tb);
        }
    },

    _setupDefaultBehaviours: function (root) {
        var self = this;
        if (this.options.clickToFront) {
            root.click(function () {
                self.toTop();
            });
        }
        jQuery('.close', root).click(function () {
            self.hide();
            return false;
        }).mousedown(function (evt) {
            evt.stopPropagation();
        });
    },

    _fire: function (event) {
        this.options[event].call(this);
    }

};
﻿/*!
 * jQuery blockUI plugin
 * Version 2.38 (29-MAR-2011)
 * @requires jQuery v1.2.3 or later
 *
 * Examples at: http://malsup.com/jquery/block/
 * Copyright (c) 2007-2010 M. Alsup
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Thanks to Amir-Hossein Sobhi for some excellent contributions!
 */

;(function ($) {

    if (/1\.(0|1|2)\.(0|1|2)/.test($.fn.jquery) || /^1.1/.test($.fn.jquery)) {
        alert('blockUI requires jQuery v1.2.3 or later!  You are using v' + $.fn.jquery);
        return;
    }

    $.fn._fadeIn = $.fn.fadeIn;

    var noOp = function () {
    };

// this bit is to ensure we don't call setExpression when we shouldn't (with extra muscle to handle
// retarded userAgent strings on Vista)
    var mode = document.documentMode || 0;
    var setExpr = $.browser.msie && (($.browser.version < 8 && !mode) || mode < 8);
    var ie6 = $.browser.msie && /MSIE 6.0/.test(navigator.userAgent) && !mode;

// global $ methods for blocking/unblocking the entire page
    $.blockUI = function (opts) {
        install(window, opts);
    };
    $.unblockUI = function (opts) {
        remove(window, opts);
    };

// convenience method for quick growl-like notifications  (http://www.google.com/search?q=growl)
    $.growlUI = function (title, message, timeout, onClose) {
        var $m = $('<div class="growlUI"></div>');
        if (title) $m.append('<h1>' + title + '</h1>');
        if (message) $m.append('<h2>' + message + '</h2>');
        if (timeout == undefined) timeout = 3000;
        $.blockUI({
            message: $m, fadeIn: 700, fadeOut: 1000, centerY: false,
            timeout: timeout, showOverlay: false,
            onUnblock: onClose,
            css: $.blockUI.defaults.growlCSS
        });
    };

// plugin method for blocking element content
    $.fn.block = function (opts) {
        return this.unblock({fadeOut: 0}).each(function () {
            if ($.css(this, 'position') == 'static')
                this.style.position = 'relative';
            if ($.browser.msie)
                this.style.zoom = 1; // force 'hasLayout'
            install(this, opts);
        });
    };

// plugin method for unblocking element content
    $.fn.unblock = function (opts) {
        return this.each(function () {
            remove(this, opts);
        });
    };

    $.blockUI.version = 2.38; // 2nd generation blocking at no extra cost!

// override these in your code to change the default behavior and style
    $.blockUI.defaults = {
        // message displayed when blocking (use null for no message)
        message: '<h1>Please wait...</h1>',

        title: null,	  // title string; only used when theme == true
        draggable: true,  // only used when theme == true (requires jquery-ui.js to be loaded)

        theme: false, // set to true to use with jQuery UI themes

        // styles for the message when blocking; if you wish to disable
        // these and use an external stylesheet then do this in your code:
        // $.blockUI.defaults.css = {};
        css: {
            padding: 0,
            margin: 0,
            width: '30%',
            top: '40%',
            left: '35%',
            textAlign: 'center',
            color: '#000',
            border: '3px solid #aaa',
            backgroundColor: '#fff',
            cursor: 'wait'
        },

        // minimal style set used when themes are used
        themedCSS: {
            width: '30%',
            top: '40%',
            left: '35%'
        },

        // styles for the overlay
        overlayCSS: {
            backgroundColor: '#000',
            opacity: 0.6,
            cursor: 'wait'
        },

        // styles applied when using $.growlUI
        growlCSS: {
            width: '350px',
            top: '10px',
            left: '',
            right: '10px',
            border: 'none',
            padding: '5px',
            opacity: 0.6,
            cursor: 'default',
            color: '#fff',
            backgroundColor: '#000',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            'border-radius': '10px'
        },

        // IE issues: 'about:blank' fails on HTTPS and javascript:false is s-l-o-w
        // (hat tip to Jorge H. N. de Vasconcelos)
        iframeSrc: /^https/i.test(window.location.href || '') ? 'javascript:false' : 'about:blank',

        // force usage of iframe in non-IE browsers (handy for blocking applets)
        forceIframe: false,

        // z-index for the blocking overlay
        baseZ: 1000,

        // set these to true to have the message automatically centered
        centerX: true, // <-- only effects element blocking (page block controlled via css above)
        centerY: true,

        // allow body element to be stetched in ie6; this makes blocking look better
        // on "short" pages.  disable if you wish to prevent changes to the body height
        allowBodyStretch: true,

        // enable if you want key and mouse events to be disabled for content that is blocked
        bindEvents: true,

        // be default blockUI will supress tab navigation from leaving blocking content
        // (if bindEvents is true)
        constrainTabKey: true,

        // fadeIn time in millis; set to 0 to disable fadeIn on block
        fadeIn: 200,

        // fadeOut time in millis; set to 0 to disable fadeOut on unblock
        fadeOut: 400,

        // time in millis to wait before auto-unblocking; set to 0 to disable auto-unblock
        timeout: 0,

        // disable if you don't want to show the overlay
        showOverlay: true,

        // if true, focus will be placed in the first available input field when
        // page blocking
        focusInput: true,

        // suppresses the use of overlay styles on FF/Linux (due to performance issues with opacity)
        applyPlatformOpacityRules: true,

        // callback method invoked when fadeIn has completed and blocking message is visible
        onBlock: null,

        // callback method invoked when unblocking has completed; the callback is
        // passed the element that has been unblocked (which is the window object for page
        // blocks) and the options that were passed to the unblock call:
        //	 onUnblock(element, options)
        onUnblock: null,

        // don't ask; if you really must know: http://groups.google.com/group/jquery-en/browse_thread/thread/36640a8730503595/2f6a79a77a78e493#2f6a79a77a78e493
        quirksmodeOffsetHack: 4,

        // class name of the message block
        blockMsgClass: 'blockMsg'
    };

// private data and functions follow...

    var pageBlock = null;
    var pageBlockEls = [];

    function install(el, opts) {
        var full = (el == window);
        var msg = opts && opts.message !== undefined ? opts.message : undefined;
        opts = $.extend({}, $.blockUI.defaults, opts || {});
        opts.overlayCSS = $.extend({}, $.blockUI.defaults.overlayCSS, opts.overlayCSS || {});
        var css = $.extend({}, $.blockUI.defaults.css, opts.css || {});
        var themedCSS = $.extend({}, $.blockUI.defaults.themedCSS, opts.themedCSS || {});
        msg = msg === undefined ? opts.message : msg;

        // remove the current block (if there is one)
        if (full && pageBlock)
            remove(window, {fadeOut: 0});

        // if an existing element is being used as the blocking content then we capture
        // its current place in the DOM (and current display style) so we can restore
        // it when we unblock
        if (msg && typeof msg != 'string' && (msg.parentNode || msg.jquery)) {
            var node = msg.jquery ? msg[0] : msg;
            var data = {};
            $(el).data('blockUI.history', data);
            data.el = node;
            data.parent = node.parentNode;
            data.display = node.style.display;
            data.position = node.style.position;
            if (data.parent)
                data.parent.removeChild(node);
        }

        var z = opts.baseZ;

        // blockUI uses 3 layers for blocking, for simplicity they are all used on every platform;
        // layer1 is the iframe layer which is used to supress bleed through of underlying content
        // layer2 is the overlay layer which has opacity and a wait cursor (by default)
        // layer3 is the message content that is displayed while blocking

        var lyr1 = ($.browser.msie || opts.forceIframe)
            ? $('<iframe class="blockUI" style="z-index:' + (z++) + ';display:none;border:none;margin:0;padding:0;position:absolute;width:100%;height:100%;top:0;left:0" src="' + opts.iframeSrc + '"></iframe>')
            : $('<div class="blockUI" style="display:none"></div>');

        var lyr2 = opts.theme
            ? $('<div class="blockUI blockOverlay ui-widget-overlay" style="z-index:' + (z++) + ';display:none"></div>')
            : $('<div class="blockUI blockOverlay" style="z-index:' + (z++) + ';display:none;border:none;margin:0;padding:0;width:100%;height:100%;top:0;left:0"></div>');

        var lyr3, s;
        if (opts.theme && full) {
            s = '<div class="blockUI ' + opts.blockMsgClass + ' blockPage ui-dialog ui-widget ui-corner-all" style="z-index:' + z + ';display:none;position:fixed">' +
                '<div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">' + (opts.title || '&nbsp;') + '</div>' +
                '<div class="ui-widget-content ui-dialog-content"></div>' +
                '</div>';
        }
        else if (opts.theme) {
            s = '<div class="blockUI ' + opts.blockMsgClass + ' blockElement ui-dialog ui-widget ui-corner-all" style="z-index:' + z + ';display:none;position:absolute">' +
                '<div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">' + (opts.title || '&nbsp;') + '</div>' +
                '<div class="ui-widget-content ui-dialog-content"></div>' +
                '</div>';
        }
        else if (full) {
            s = '<div class="blockUI ' + opts.blockMsgClass + ' blockPage" style="z-index:' + z + ';display:none;position:fixed"></div>';
        }
        else {
            s = '<div class="blockUI ' + opts.blockMsgClass + ' blockElement" style="z-index:' + z + ';display:none;position:absolute"></div>';
        }
        lyr3 = $(s);

        // if we have a message, style it
        if (msg) {
            if (opts.theme) {
                lyr3.css(themedCSS);
                lyr3.addClass('ui-widget-content');
            }
            else
                lyr3.css(css);
        }

        // style the overlay
        if (!opts.theme && (!opts.applyPlatformOpacityRules || !($.browser.mozilla && /Linux/.test(navigator.platform))))
            lyr2.css(opts.overlayCSS);
        lyr2.css('position', full ? 'fixed' : 'absolute');

        // make iframe layer transparent in IE
        if ($.browser.msie || opts.forceIframe)
            lyr1.css('opacity', 0.0);

        //$([lyr1[0],lyr2[0],lyr3[0]]).appendTo(full ? 'body' : el);
        var layers = [lyr1, lyr2, lyr3], $par = full ? $('body') : $(el);
        $.each(layers, function () {
            this.appendTo($par);
        });

        if (opts.theme && opts.draggable && $.fn.draggable) {
            lyr3.draggable({
                handle: '.ui-dialog-titlebar',
                cancel: 'li'
            });
        }

        // ie7 must use absolute positioning in quirks mode and to account for activex issues (when scrolling)
        var expr = setExpr && (!$.boxModel || $('object,embed', full ? null : el).length > 0);
        if (ie6 || expr) {
            // give body 100% height
            if (full && opts.allowBodyStretch && $.boxModel)
                $('html,body').css('height', '100%');

            // fix ie6 issue when blocked element has a border width
            if ((ie6 || !$.boxModel) && !full) {
                var t = sz(el, 'borderTopWidth'), l = sz(el, 'borderLeftWidth');
                var fixT = t ? '(0 - ' + t + ')' : 0;
                var fixL = l ? '(0 - ' + l + ')' : 0;
            }

            // simulate fixed position
            $.each([lyr1, lyr2, lyr3], function (i, o) {
                var s = o[0].style;
                s.position = 'absolute';
                if (i < 2) {
                    full ? s.setExpression('height', 'Math.max(document.body.scrollHeight, document.body.offsetHeight) - (jQuery.boxModel?0:' + opts.quirksmodeOffsetHack + ') + "px"')
                        : s.setExpression('height', 'this.parentNode.offsetHeight + "px"');
                    full ? s.setExpression('width', 'jQuery.boxModel && document.documentElement.clientWidth || document.body.clientWidth + "px"')
                        : s.setExpression('width', 'this.parentNode.offsetWidth + "px"');
                    if (fixL) s.setExpression('left', fixL);
                    if (fixT) s.setExpression('top', fixT);
                }
                else if (opts.centerY) {
                    if (full) s.setExpression('top', '(document.documentElement.clientHeight || document.body.clientHeight) / 2 - (this.offsetHeight / 2) + (blah = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + "px"');
                    s.marginTop = 0;
                }
                else if (!opts.centerY && full) {
                    var top = (opts.css && opts.css.top) ? parseInt(opts.css.top) : 0;
                    var expression = '((document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + ' + top + ') + "px"';
                    s.setExpression('top', expression);
                }
            });
        }

        // show the message
        if (msg) {
            if (opts.theme)
                lyr3.find('.ui-widget-content').append(msg);
            else
                lyr3.append(msg);
            if (msg.jquery || msg.nodeType)
                $(msg).show();
        }

        if (($.browser.msie || opts.forceIframe) && opts.showOverlay)
            lyr1.show(); // opacity is zero
        if (opts.fadeIn) {
            var cb = opts.onBlock ? opts.onBlock : noOp;
            var cb1 = (opts.showOverlay && !msg) ? cb : noOp;
            var cb2 = msg ? cb : noOp;
            if (opts.showOverlay)
                lyr2._fadeIn(opts.fadeIn, cb1);
            if (msg)
                lyr3._fadeIn(opts.fadeIn, cb2);
        }
        else {
            if (opts.showOverlay)
                lyr2.show();
            if (msg)
                lyr3.show();
            if (opts.onBlock)
                opts.onBlock();
        }

        // bind key and mouse events
        bind(1, el, opts);

        if (full) {
            pageBlock = lyr3[0];
            pageBlockEls = $(':input:enabled:visible', pageBlock);
            if (opts.focusInput)
                setTimeout(focus, 20);
        }
        else
            center(lyr3[0], opts.centerX, opts.centerY);

        if (opts.timeout) {
            // auto-unblock
            var to = setTimeout(function () {
                full ? $.unblockUI(opts) : $(el).unblock(opts);
            }, opts.timeout);
            $(el).data('blockUI.timeout', to);
        }
    };

// remove the block
    function remove(el, opts) {
        var full = (el == window);
        var $el = $(el);
        var data = $el.data('blockUI.history');
        var to = $el.data('blockUI.timeout');
        if (to) {
            clearTimeout(to);
            $el.removeData('blockUI.timeout');
        }
        opts = $.extend({}, $.blockUI.defaults, opts || {});
        bind(0, el, opts); // unbind events

        var els;
        if (full) // crazy selector to handle odd field errors in ie6/7
            els = $('body').children().filter('.blockUI').add('body > .blockUI');
        else
            els = $('.blockUI', el);

        if (full)
            pageBlock = pageBlockEls = null;

        if (opts.fadeOut) {
            els.fadeOut(opts.fadeOut);
            setTimeout(function () {
                reset(els, data, opts, el);
            }, opts.fadeOut);
        }
        else
            reset(els, data, opts, el);
    };

// move blocking element back into the DOM where it started
    function reset(els, data, opts, el) {
        els.each(function (i, o) {
            // remove via DOM calls so we don't lose event handlers
            if (this.parentNode)
                this.parentNode.removeChild(this);
        });

        if (data && data.el) {
            data.el.style.display = data.display;
            data.el.style.position = data.position;
            if (data.parent)
                data.parent.appendChild(data.el);
            $(el).removeData('blockUI.history');
        }

        if (typeof opts.onUnblock == 'function')
            opts.onUnblock(el, opts);
    };

// bind/unbind the handler
    function bind(b, el, opts) {
        var full = el == window, $el = $(el);

        // don't bother unbinding if there is nothing to unbind
        if (!b && (full && !pageBlock || !full && !$el.data('blockUI.isBlocked')))
            return;
        if (!full)
            $el.data('blockUI.isBlocked', b);

        // don't bind events when overlay is not in use or if bindEvents is false
        if (!opts.bindEvents || (b && !opts.showOverlay))
            return;

        // bind anchors and inputs for mouse and key events
        var events = 'mousedown mouseup keydown keypress';
        b ? $(document).bind(events, opts, handler) : $(document).unbind(events, handler);

// former impl...
//	   var $e = $('a,:input');
//	   b ? $e.bind(events, opts, handler) : $e.unbind(events, handler);
    };

// event handler to suppress keyboard/mouse events when blocking
    function handler(e) {
        // allow tab navigation (conditionally)
        if (e.keyCode && e.keyCode == 9) {
            if (pageBlock && e.data.constrainTabKey) {
                var els = pageBlockEls;
                var fwd = !e.shiftKey && e.target === els[els.length - 1];
                var back = e.shiftKey && e.target === els[0];
                if (fwd || back) {
                    setTimeout(function () {
                        focus(back)
                    }, 10);
                    return false;
                }
            }
        }
        var opts = e.data;
        // allow events within the message content
        if ($(e.target).parents('div.' + opts.blockMsgClass).length > 0)
            return true;

        // allow events for content that is not being blocked
        return $(e.target).parents().children().filter('div.blockUI').length == 0;
    };

    function focus(back) {
        if (!pageBlockEls)
            return;
        var e = pageBlockEls[back === true ? pageBlockEls.length - 1 : 0];
        if (e)
            e.focus();
    };

    function center(el, x, y) {
        var p = el.parentNode, s = el.style;
        var l = ((p.offsetWidth - el.offsetWidth) / 2) - sz(p, 'borderLeftWidth');
        var t = ((p.offsetHeight - el.offsetHeight) / 2) - sz(p, 'borderTopWidth');
        if (x) s.left = l > 0 ? (l + 'px') : '0';
        if (y) s.top = t > 0 ? (t + 'px') : '0';
    };

    function sz(el, p) {
        return parseInt($.css(el, p)) || 0;
    };

})(jQuery);
/**
 * validate- jQuery Plug-in
 * @version 1.0
 * @author kingapex
 * Copyright 2009 enation
 */
(function ($) {
    $.Validator = {};
    var DefLang = {
        validate_fail: '您提交的表单中有无效内容，请检查高亮部分内容。',
        required: '此项为必填',
        string: '',
        is_not_int: '此选项必须为整型数字',
        is_not_float: '此选项必须为浮点型数字',
        is_not_date: '日期格式不正确',
        is_not_email: 'email格式不正确',
        is_not_mobile: '手机号码格式不正确',
        is_not_id_card: 'cart not valid...',
        is_not_post_code: '邮政编码格式不正确',
        is_not_url: '不是有效的地址格式'


    };
    $.isDate = function (val) {
        var reg = /^\d{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
        return reg.test(val);
    };
    $.isTime = function (val) {
        var reg = /^([0-1]\d|2[0-3]):[0-5]\d:[0-5]\d$/;
        return reg.test(val);
    };
    $.isEmail = function (val) {
        var reg = /^([a-z0-9+_]|\-|\.|\-)+@([\w|\-]+\.)+[a-z]{2,4}$/i;
        return reg.test(val);
    };
    $.isNumber = function (val) {
        if (val == '') return true;
        return parseInt(val) == val;
    }

    function validator_lang_exist(key) {
        if (typeof(DefLang) != "object") return false;
        if (typeof(DefLang[key]) == 'string') return true;
        return false;
    }


    dt_string = function () {
        this.check = function (val) {
            return true;
        };
        this.test = function (val, testStr) {
            return new RegExp(testStr).test(val)
        };
        this.errorMsg = function () {
            return DefLang.string;
        };
    };
    dt_int = function () {
        this.check = function (val) {
            if (val == '') return true;
            return parseInt(val) == val;
        };
        this.test = function (val, testStr) {
            var arr = testStr.split(',');
            val = parseInt(val);
            var test = arr[0].trim();
            if (test != '*' && val < parseInt(test)) return false;
            if (arr.length > 1) {
                test = arr[1].trim();
                if (test != '*' && val > parseInt(test)) return false;
            }
            return true;
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_int')) {
                return DefLang.is_not_int
            } else {
                return "this value is not int!"
            }
        };
    };


    dt_float = function () {
        this.check = function (val) {
            if (val == '') return true;
            return parseFloat(val) == val;
        };
        this.test = function (val, testStr) {
            if (val == '') return true;
            var arr = testStr.split(',');
            val = parseFloat(val);
            var test = arr[0].trim();
            if (test != '*' && val < parseFloat(test)) return false;
            if (arr.length > 1) {
                test = arr[1].trim();
                if (test != '*' && val > parseFloat(test)) return false;
            }
            return true;
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_float')) {
                return DefLang.is_not_float
            } else {
                return "this value is not float!"
            }
        };
    };
    dt_date = function () {
        var self = this;
        this.check = function (val) {
            return $.isDate(val);
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_date')) {
                return DefLang.is_not_date
            } else {
                return "this value is not date!"
            }
        };
    };

    dt_email = function () {
        this.check = function (val) {
            if (val == '') return true;
            return $.isEmail(val);
        };
        this.test = function () {
            return true
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_email')) {
                return DefLang.is_not_email
            } else {
                return "this value is not email!"
            }
        };
    };
    dt_tel_num = function () {
        this.check = function (val) {
            return /^[\d|\+|\_|\-]+$/.test(val);
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_tel_num')) {
                return DefLang.is_not_tel_num
            } else {
                return "this value is not telephone Number!"
            }
        };
    };
    dt_mobile = function () {
        this.check = function (val) {
            return /^[\d|-|\+]{3,20}$/.test(val);
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_mobile')) {
                return DefLang.is_not_mobile
            } else {
                return "this value is not mobile Number!"
            }
        };
    };
    dt_id_card = function () {
        this.check = function (val) {
            return true
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_id_card')) {
                return DefLang.is_not_id_card
            } else {
                return "this value is not IDCard Number!"
            }
        };
    };
    dt_post_code = function () {
        this.check = function (val) {
            return /^[1-9]\d{5}(?!\d)$/.test(val);
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_post_code')) {
                return DefLang.is_not_post_code
            } else {
                return "this value is not postCode!"
            }
        };
    };
    dt_url = function () {
        this.check = function (val) {
            return val.match(/^(?:^(https?):\/\/[\-A-Z0-9+&@#\/%?=~_|!:,.;]*[\-A-Z0-9+&@#\/%=~_|]$)$/i);
        };
        this.errorMsg = function () {
            if (validator_lang_exist('is_not_url')) {
                return DefLang.is_not_url
            } else {
                return "this value is not url!"
            }
        };
    };
    dt_file = function () {
        this.check = function (val) {
            return true
        };
        this.test = function (val, testStr) {
            return true
        };
    };


    var Validator = {
        types: {
            "string": new dt_string(),
            "int": new dt_int(),
            "date": new dt_date(),
            "email": new dt_email,
            "tel_num": new dt_tel_num(),
            "mobile": new dt_mobile(),
            "id_card": new dt_id_card(),
            "post_code": new dt_post_code(),
            "url": new dt_url(),
            "region": new dt_string(),
            "file": new dt_file(),
            "float": new dt_float()
        },
        /*
         * 显示提示信息
         */
        note: function (frm_ele) {
            var required = frm_ele.attr("required");
            if (required) {
                this.showNote(frm_ele, DefLang.required);
            }
        },


        /*
         * 校验一个元素
         */
        check: function (frm_ele) {
            if (!frm_ele) return true;
            if (frm_ele.attr("disabled")) return true;
            try {

                var required = frm_ele.attr("required");

                if (required) {
                    if ($.trim(frm_ele.val()) == '') {
                        this.showError(frm_ele, DefLang.required);

                        return false;
                    }
                }

                var dataType = frm_ele.attr("dataType");
                if (dataType && this.types[dataType]) {
                    var checker = this.types[dataType];
                    if (checker.check(frm_ele.val())) {
                        this.showOk(frm_ele, "");
                    } else {
                        this.showError(frm_ele, checker.errorMsg());
                        return false;
                    }
                }

                var fun = frm_ele.attr("fun");
                eval('result= typeof(' + fun + ') == "function"');
                if (result == true) {

                    var r = eval(fun + "(frm_ele.val())");
                    if (typeof(r) == 'string') {
                        this.showError(frm_ele, r);
                        return false;
                    }

                    if (!r) return false;

                }

                this.showOk(frm_ele, "");
                return true;
            } catch (e) {
                //alert(e);
                //alert(frm_ele.attr("name"));
            }
        },


        /*
         * 显示提示信息
         */
        showNote: function (frm_ele, msg) {
            var note_span = this.getNoteSpan(frm_ele);
            note_span.removeClass("error");
            note_span.removeClass("ok");
            note_span.addClass("note");
            note_span.text(msg);
        },

        /*
         * 显示验证正确
         */
        showOk: function (frm_ele, msg) {
            var note_span = this.getNoteSpan(frm_ele);
            note_span.removeClass("error");
            note_span.removeClass("note");
            note_span.addClass("ok");
            note_span.text(msg);
        },

        /*
         * 显示错误
         */
        showError: function (frm_ele, msg) {

            var note_span = this.getNoteSpan(frm_ele);
            note_span.removeClass("ok");
            note_span.removeClass("note");
            note_span.addClass("error");
            note_span.text(msg);
        },


        /*
         * 获取提示的span
         */
        getNoteSpan: function (frm_ele) {
            var note_span = null;
            if (typeof(frm_ele.attr("tip")) == "undefined") {
                note_span = frm_ele.next("span.tip");
                if (note_span && note_span.size() > 0) {
                } else {
                    note_span = $("<span class=\"tip\"></span>").insertAfter(frm_ele);
                }
            } else {
                note_span = $("#" + frm_ele.attr("tip"));
            }
            return note_span;
        }
    };

    var opts, inputs;

    /*
     * 检查所有的表单项
     */
    var checkAll = function () {
        var result = true;

        inputs.each(function () {
            if (this) {
                var el = $(this);
                if (el.attr("dataType")) {
                    if (!Validator.check(el)) {
                        el.focus();
                        result = false;
                    }
                }
            }
        });
        return result;
    };

    $.fn.checkall = function () {
        var result = true;
        $(".noNull").each(function () {
            if (result && (typeof($(this).val()) == "undefined" || $(this).val().length == 0)) {
                alert($(this).attr("msg"));
                result = false;
            }
        });
        if (result) {
            if (checkAll()) {
                $(this).attr("validate", "true");
                return true;
            } else {
                $(this).attr("validate", "false");
                alert(DefLang.validate_fail);
                return false;
            }
        }
    };

    $.fn.validate = function (options, customFun) {

        var defaults = {
            types: 'input[type=text],input[type=password],select,textarea',
            lang: DefLang
        };

        opts = $.extend({}, defaults, options || {});

        DefLang = opts.lang;

        var self = this;

        inputs = this.find(opts.types);

        this.submit(function () {

            if (customFun) {
                if (!customFun()) {
                    alert(DefLang.validate_fail);
                    return false;
                }
            }
            if (checkAll()) {
                $(this).attr("validate", "true");
                return true;
            } else {
                $(this).attr("validate", "false");
                alert(DefLang.validate_fail);
                return false;
            }


        });


        inputs.blur(function () {
                var el = $(this);
                if (!Validator.check(el)) {
                    el.addClass("fail");
                } else {
                    el.removeClass("fail");
                }
            })
            .focus(function () {
                Validator.note($(this));
            });

    };


})(jQuery);
(function ($) {

    function create() {
        var loadding = $("#loading");
        if (loadding.size() == 0)
            loadding = $("<div id=\"loading\" class=\"loading\" style='z-index:3000' />").appendTo($("body")).hide();
        return loadding;
    }

    $.Loading = $.Loading || {};
    $.Loading.show = function (text) {
        var loading = create();

        if (this.text) {
            loading.html(this.text);
        } else {
            if (text)
                loading.html(text);
        }

        $("<div style=\"height: 100%; width: 100%; position: fixed; left: 0pt; top: 0pt; z-index: 2999; opacity: 0.4;\" class=\"jqmOverlay\"></div>").appendTo($("body"));
        loading.show();
    };

    $.Loading.hide = function () {
        create().hide();
        $(".jqmOverlay").remove();
    };


})(jQuery);
var Eop = Eop || {};
Eop.Util = {};

/**
 * 将一个json对象转为字串
 */
Eop.Util.jsonToString = function (obj) {
    var THIS = this;
    switch (typeof (obj)) {
        case 'string':
            return '"' + obj.replace(/(["\\])/g, '\\$1') + '"';
        case 'array':
            return '[' + obj.map(THIS.jsonToString).join(',') + ']';
        case 'object':
            if (obj instanceof Array) {
                var strArr = [];
                var len = obj.length;
                for (var i = 0; i < len; i++) {
                    strArr.push(THIS.jsonToString(obj[i]));
                }
                return '[' + strArr.join(',') + ']';
            } else if (obj == null) {
                return 'null';

            } else {
                var string = [];
                for (var property in obj)
                    string.push(THIS.jsonToString(property) + ':'
                        + THIS.jsonToString(obj[property]));
                return '{' + string.join(',') + '}';
            }
        case 'number':
            return obj;
        case false:
            return obj;
    }
};

jQuery.cookie = function (name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        // CAUTION: Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};


/* jQuery UI Date Picker v3.4.3 (previously jQuery Calendar)
 Written by Marc Grabanski (m@marcgrabanski.com) and Keith Wood (kbwood@virginbroadband.com.au).

 Copyright (c) 2007 Marc Grabanski (http://marcgrabanski.com/code/ui-datepicker)
 Dual licensed under the MIT (MIT-LICENSE.txt)
 and GPL (GPL-LICENSE.txt) licenses.
 Date: 09-03-2007  */

;(function ($) { // hide the namespace

    /* Date picker manager.
     Use the singleton instance of this class, $.datepicker, to interact with the date picker.
     Settings for (groups of) date pickers are maintained in an instance object
     (DatepickerInstance), allowing multiple different settings on the same page. */

    function Datepicker() {
        this.debug = false; // Change this to true to start debugging
        this._nextId = 0; // Next ID for a date picker instance
        this._inst = []; // List of instances indexed by ID
        this._curInst = null; // The current instance in use
        this._disabledInputs = []; // List of date picker inputs that have been disabled
        this._datepickerShowing = false; // True if the popup picker is showing , false if not
        this._inDialog = false; // True if showing within a "dialog", false if not
        this.regional = []; // Available regional settings, indexed by language code
        this.regional[''] = { // Default regional settings
            clearText: 'Clear', // Display text for clear link
            clearStatus: 'Erase the current date', // Status text for clear link
            closeText: 'Close', // Display text for close link
            closeStatus: 'Close without change', // Status text for close link
            prevText: '&#x3c;Prev', // Display text for previous month link
            prevStatus: 'Show the previous month', // Status text for previous month link
            nextText: 'Next&#x3e;', // Display text for next month link
            nextStatus: 'Show the next month', // Status text for next month link
            currentText: 'Today', // Display text for current month link
            currentStatus: 'Show the current month', // Status text for current month link
            monthNames: ['January', 'February', 'March', 'April', 'May', 'June',
                'July', 'August', 'September', 'October', 'November', 'December'], // Names of months for drop-down and formatting
            monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'], // For formatting
            monthStatus: 'Show a different month', // Status text for selecting a month
            yearStatus: 'Show a different year', // Status text for selecting a year
            weekHeader: 'Wk', // Header for the week of the year column
            weekStatus: 'Week of the year', // Status text for the week of the year column
            dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'], // For formatting
            dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'], // For formatting
            dayNamesMin: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'], // Column headings for days starting at Sunday
            dayStatus: 'Set DD as first week day', // Status text for the day of the week selection
            dateStatus: 'Select DD, M d', // Status text for the date selection
            dateFormat: 'mm/dd/yy', // See format options on parseDate
            firstDay: 0, // The first day of the week, Sun = 0, Mon = 1, ...
            initStatus: 'Select a date', // Initial Status text on opening
            isRTL: false // True if right-to-left language, false if left-to-right
        };
        this._defaults = { // Global defaults for all the date picker instances
            showOn: 'focus', // 'focus' for popup on focus,
            // 'button' for trigger button, or 'both' for either
            showAnim: 'show', // Name of jQuery animation for popup
            defaultDate: null, // Used when field is blank: actual date,
            // +/-number for offset from today, null for today
            appendText: '', // Display text following the input box, e.g. showing the format
            buttonText: '...', // Text for trigger button
            buttonImage: '', // URL for trigger button image
            buttonImageOnly: false, // True if the image appears alone, false if it appears on a button
            closeAtTop: true, // True to have the clear/close at the top,
            // false to have them at the bottom
            mandatory: false, // True to hide the Clear link, false to include it
            hideIfNoPrevNext: false, // True to hide next/previous month links
            // if not applicable, false to just disable them
            changeMonth: true, // True if month can be selected directly, false if only prev/next
            changeYear: true, // True if year can be selected directly, false if only prev/next
            yearRange: '-10:+10', // Range of years to display in drop-down,
            // either relative to current year (-nn:+nn) or absolute (nnnn:nnnn)
            changeFirstDay: true, // True to click on day name to change, false to remain as set
            showOtherMonths: false, // True to show dates in other months, false to leave blank
            showWeeks: false, // True to show week of the year, false to omit
            calculateWeek: this.iso8601Week, // How to calculate the week of the year,
            // takes a Date and returns the number of the week for it
            shortYearCutoff: '+10', // Short year values < this are in the current century,
            // > this are in the previous century, 
            // string value starting with '+' for current year + value
            showStatus: false, // True to show status bar at bottom, false to not show it
            statusForDate: this.dateStatus, // Function to provide status text for a date -
            // takes date and instance as parameters, returns display text
            minDate: null, // The earliest selectable date, or null for no limit
            maxDate: null, // The latest selectable date, or null for no limit
            speed: 'normal', // Speed of display/closure
            beforeShowDay: null, // Function that takes a date and returns an array with
            // [0] = true if selectable, false if not,
            // [1] = custom CSS class name(s) or '', e.g. $.datepicker.noWeekends
            beforeShow: null, // Function that takes an input field and
            // returns a set of custom settings for the date picker
            onSelect: null, // Define a callback function when a date is selected
            onClose: null, // Define a callback function when the datepicker is closed
            numberOfMonths: 1, // Number of months to show at a time
            stepMonths: 1, // Number of months to step back/forward
            rangeSelect: false, // Allows for selecting a date range on one date picker
            rangeSeparator: ' - ' // Text between two dates in a range
        };
        $.extend(this._defaults, this.regional['']);
        this._datepickerDiv = $('<div id="datepicker_div">');
    }

    $.extend(Datepicker.prototype, {
        /* Class name added to elements to indicate already configured with a date picker. */
        markerClassName: 'hasDatepicker',

        /* Debug logging (if enabled). */
        log: function () {
            if (this.debug)
                console.log.apply('', arguments);
        },

        /* Register a new date picker instance - with custom settings. */
        _register: function (inst) {
            var id = this._nextId++;
            this._inst[id] = inst;
            return id;
        },

        /* Retrieve a particular date picker instance based on its ID. */
        _getInst: function (id) {
            return this._inst[id] || id;
        },

        /* Override the default settings for all instances of the date picker. 
         @param  settings  object - the new settings to use as defaults (anonymous object)
         @return the manager object */
        setDefaults: function (settings) {
            extendRemove(this._defaults, settings || {});
            return this;
        },

        /* Attach the date picker to a jQuery selection.
         @param  target    element - the target input field or division or span
         @param  settings  object - the new settings to use for this date picker instance (anonymous) */
        _attachDatepicker: function (target, settings) {
            // check for settings on the control itself - in namespace 'date:'
            var inlineSettings = null;
            for (attrName in this._defaults) {
                var attrValue = target.getAttribute('date:' + attrName);
                if (attrValue) {
                    inlineSettings = inlineSettings || {};
                    try {
                        inlineSettings[attrName] = eval(attrValue);
                    } catch (err) {
                        inlineSettings[attrName] = attrValue;
                    }
                }
            }
            var nodeName = target.nodeName.toLowerCase();
            var instSettings = (inlineSettings ?
                $.extend(settings || {}, inlineSettings || {}) : settings);
            if (nodeName == 'input') {
                var inst = (inst && !inlineSettings ? inst :
                    new DatepickerInstance(instSettings, false));
                this._connectDatepicker(target, inst);
            } else if (nodeName == 'div' || nodeName == 'span') {
                var inst = new DatepickerInstance(instSettings, true);
                this._inlineDatepicker(target, inst);
            }
        },

        /* Detach a datepicker from its control.
         @param  target    element - the target input field or division or span */
        _destroyDatepicker: function (target) {
            var nodeName = target.nodeName.toLowerCase();
            var calId = target._calId;
            target._calId = null;
            var $target = $(target);
            if (nodeName == 'input') {
                $target.siblings('.datepicker_append').replaceWith('').end()
                    .siblings('.datepicker_trigger').replaceWith('').end()
                    .removeClass(this.markerClassName)
                    .unbind('focus', this._showDatepicker)
                    .unbind('keydown', this._doKeyDown)
                    .unbind('keypress', this._doKeyPress);
                var wrapper = $target.parents('.datepicker_wrap');
                if (wrapper)
                    wrapper.replaceWith(wrapper.html());
            } else if (nodeName == 'div' || nodeName == 'span')
                $target.removeClass(this.markerClassName).empty();
            if ($('input[_calId=' + calId + ']').length == 0)
            // clean up if last for this ID
                this._inst[calId] = null;
        },

        /* Enable the date picker to a jQuery selection.
         @param  target    element - the target input field or division or span */
        _enableDatepicker: function (target) {
            target.disabled = false;
            $(target).siblings('button.datepicker_trigger').each(function () {
                this.disabled = false;
            }).end()
                .siblings('img.datepicker_trigger').css({opacity: '1.0', cursor: ''});
            this._disabledInputs = $.map(this._disabledInputs,
                function (value) {
                    return (value == target ? null : value);
                }); // delete entry
        },

        /* Disable the date picker to a jQuery selection.
         @param  target    element - the target input field or division or span */
        _disableDatepicker: function (target) {
            target.disabled = true;
            $(target).siblings('button.datepicker_trigger').each(function () {
                this.disabled = true;
            }).end()
                .siblings('img.datepicker_trigger').css({opacity: '0.5', cursor: 'default'});
            this._disabledInputs = $.map($.datepicker._disabledInputs,
                function (value) {
                    return (value == target ? null : value);
                }); // delete entry
            this._disabledInputs[$.datepicker._disabledInputs.length] = target;
        },

        /* Is the first field in a jQuery collection disabled as a datepicker?
         @param  target    element - the target input field or division or span
         @return boolean - true if disabled, false if enabled */
        _isDisabledDatepicker: function (target) {
            if (!target)
                return false;
            for (var i = 0; i < this._disabledInputs.length; i++) {
                if (this._disabledInputs[i] == target)
                    return true;
            }
            return false;
        },

        /* Update the settings for a date picker attached to an input field or division.
         @param  target  element - the target input field or division or span
         @param  name    string - the name of the setting to change or
         object - the new settings to update
         @param  value   any - the new value for the setting (omit if above is an object) */
        _changeDatepicker: function (target, name, value) {
            var settings = name || {};
            if (typeof name == 'string') {
                settings = {};
                settings[name] = value;
            }
            if (inst = this._getInst(target._calId)) {
                extendRemove(inst._settings, settings);
                this._updateDatepicker(inst);
            }
        },

        /* Set the dates for a jQuery selection.
         @param  target   element - the target input field or division or span
         @param  date     Date - the new date
         @param  endDate  Date - the new end date for a range (optional) */
        _setDateDatepicker: function (target, date, endDate) {
            if (inst = this._getInst(target._calId)) {
                inst._setDate(date, endDate);
                this._updateDatepicker(inst);
            }
        },

        /* Get the date(s) for the first entry in a jQuery selection.
         @param  target  element - the target input field or division or span
         @return Date - the current date or
         Date[2] - the current dates for a range */
        _getDateDatepicker: function (target) {
            var inst = this._getInst(target._calId);
            return (inst ? inst._getDate() : null);
        },

        /* Handle keystrokes. */
        _doKeyDown: function (e) {
            var inst = $.datepicker._getInst(this._calId);
            if ($.datepicker._datepickerShowing)
                switch (e.keyCode) {
                    case 9:
                        $.datepicker._hideDatepicker(null, '');
                        break; // hide on tab out
                    case 13:
                        $.datepicker._selectDay(inst, inst._selectedMonth, inst._selectedYear,
                            $('td.datepicker_daysCellOver', inst._datepickerDiv)[0]);
                        return false; // don't submit the form
                        break; // select the value on enter
                    case 27:
                        $.datepicker._hideDatepicker(null, inst._get('speed'));
                        break; // hide on escape
                    case 33:
                        $.datepicker._adjustDate(inst,
                            (e.ctrlKey ? -1 : -inst._get('stepMonths')), (e.ctrlKey ? 'Y' : 'M'));
                        break; // previous month/year on page up/+ ctrl
                    case 34:
                        $.datepicker._adjustDate(inst,
                            (e.ctrlKey ? +1 : +inst._get('stepMonths')), (e.ctrlKey ? 'Y' : 'M'));
                        break; // next month/year on page down/+ ctrl
                    case 35:
                        if (e.ctrlKey) $.datepicker._clearDate(inst);
                        break; // clear on ctrl+end
                    case 36:
                        if (e.ctrlKey) $.datepicker._gotoToday(inst);
                        break; // current on ctrl+home
                    case 37:
                        if (e.ctrlKey) $.datepicker._adjustDate(inst, -1, 'D');
                        break; // -1 day on ctrl+left
                    case 38:
                        if (e.ctrlKey) $.datepicker._adjustDate(inst, -7, 'D');
                        break; // -1 week on ctrl+up
                    case 39:
                        if (e.ctrlKey) $.datepicker._adjustDate(inst, +1, 'D');
                        break; // +1 day on ctrl+right
                    case 40:
                        if (e.ctrlKey) $.datepicker._adjustDate(inst, +7, 'D');
                        break; // +1 week on ctrl+down
                }
            else if (e.keyCode == 36 && e.ctrlKey) // display the date picker on ctrl+home
                $.datepicker._showDatepicker(this);
        },

        /* Filter entered characters - based on date format. */
        _doKeyPress: function (e) {
            var inst = $.datepicker._getInst(this._calId);
            var chars = $.datepicker._possibleChars(inst._get('dateFormat'));
            var chr = String.fromCharCode(e.charCode == undefined ? e.keyCode : e.charCode);
            return e.ctrlKey || (chr < ' ' || !chars || chars.indexOf(chr) > -1);
        },

        /* Attach the date picker to an input field. */
        _connectDatepicker: function (target, inst) {
            var input = $(target);
            if (input.is('.' + this.markerClassName))
                return;
            var appendText = inst._get('appendText');
            var isRTL = inst._get('isRTL');
            if (appendText) {
                if (isRTL)
                    input.before('<span class="datepicker_append">' + appendText);
                else
                    input.after('<span class="datepicker_append">' + appendText);
            }
            var showOn = inst._get('showOn');
            if (showOn == 'focus' || showOn == 'both') // pop-up date picker when in the marked field
                input.click(this._showDatepicker);
            if (showOn == 'button' || showOn == 'both') { // pop-up date picker when button clicked
                input.wrap('<span class="datepicker_wrap">');
                var buttonText = inst._get('buttonText');
                var buttonImage = inst._get('buttonImage');
                var trigger = $(inst._get('buttonImageOnly') ?
                    $('<img>').addClass('datepicker_trigger').attr({
                        src: buttonImage,
                        alt: buttonText,
                        title: buttonText
                    }) :
                    $('<button>').addClass('datepicker_trigger').attr({type: 'button'}).html(buttonImage != '' ?
                        $('<img>').attr({src: buttonImage, alt: buttonText, title: buttonText}) : buttonText));
                if (isRTL)
                    input.before(trigger);
                else
                    input.after(trigger);
                trigger.click(function () {
                    if ($.datepicker._datepickerShowing && $.datepicker._lastInput == target)
                        $.datepicker._hideDatepicker();
                    else
                        $.datepicker._showDatepicker(target);
                });
            }
            input.addClass(this.markerClassName).keydown(this._doKeyDown).keypress(this._doKeyPress)
                .bind("setData.datepicker", function (event, key, value) {
                    inst._settings[key] = value;
                }).bind("getData.datepicker", function (event, key) {
                return inst._get(key);
            });
            input[0]._calId = inst._id;
        },

        /* Attach an inline date picker to a div. */
        _inlineDatepicker: function (target, inst) {
            var input = $(target);
            if (input.is('.' + this.markerClassName))
                return;
            input.addClass(this.markerClassName).append(inst._datepickerDiv)
                .bind("setData.datepicker", function (event, key, value) {
                    inst._settings[key] = value;
                }).bind("getData.datepicker", function (event, key) {
                return inst._get(key);
            });
            input[0]._calId = inst._id;
            this._updateDatepicker(inst);
        },

        /* Tidy up after displaying the date picker. */
        _inlineShow: function (inst) {
            var numMonths = inst._getNumberOfMonths(); // fix width for dynamic number of date pickers
            inst._datepickerDiv.width(numMonths[1] * $('.datepicker', inst._datepickerDiv[0]).width());
        },

        /* Pop-up the date picker in a "dialog" box.
         @param  input     element - ignored
         @param  dateText  string - the initial date to display (in the current format)
         @param  onSelect  function - the function(dateText) to call when a date is selected
         @param  settings  object - update the dialog date picker instance's settings (anonymous object)
         @param  pos       int[2] - coordinates for the dialog's position within the screen or
         event - with x/y coordinates or
         leave empty for default (screen centre)
         @return the manager object */
        _dialogDatepicker: function (input, dateText, onSelect, settings, pos) {
            var inst = this._dialogInst; // internal instance
            if (!inst) {
                inst = this._dialogInst = new DatepickerInstance({}, false);
                this._dialogInput = $('<input type="text" size="1" style="position: absolute; top: -100px;"/>');
                this._dialogInput.keydown(this._doKeyDown);
                $('body').append(this._dialogInput);
                this._dialogInput[0]._calId = inst._id;
            }
            extendRemove(inst._settings, settings || {});
            this._dialogInput.val(dateText);

            this._pos = (pos ? (pos.length ? pos : [pos.pageX, pos.pageY]) : null);
            if (!this._pos) {
                var browserWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
                var browserHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
                var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
                var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
                this._pos = // should use actual width/height below
                    [(browserWidth / 2) - 100 + scrollX, (browserHeight / 2) - 150 + scrollY];
            }

            // move input on screen for focus, but hidden behind dialog
            this._dialogInput.css('left', this._pos[0] + 'px').css('top', this._pos[1] + 'px');
            inst._settings.onSelect = onSelect;
            this._inDialog = true;
            this._datepickerDiv.addClass('datepicker_dialog');
            this._showDatepicker(this._dialogInput[0]);
            if ($.blockUI)
                $.blockUI(this._datepickerDiv);
            return this;
        },

        /* Pop-up the date picker for a given input field.
         @param  input  element - the input field attached to the date picker or
         event - if triggered by focus */
        _showDatepicker: function (input) {
            input = input.target || input;
            if (input.nodeName.toLowerCase() != 'input') // find from button/image trigger
                input = $('input', input.parentNode)[0];
            if ($.datepicker._isDisabledDatepicker(input) || $.datepicker._lastInput == input) // already here
                return;
            var inst = $.datepicker._getInst(input._calId);
            var beforeShow = inst._get('beforeShow');
            extendRemove(inst._settings, (beforeShow ? beforeShow.apply(input, [input, inst]) : {}));
            $.datepicker._hideDatepicker(null, '');
            $.datepicker._lastInput = input;
            inst._setDateFromField(input);
            if ($.datepicker._inDialog) // hide cursor
                input.value = '';
            if (!$.datepicker._pos) { // position below input
                $.datepicker._pos = $.datepicker._findPos(input);
                $.datepicker._pos[1] += input.offsetHeight; // add the height
            }
            var isFixed = false;
            $(input).parents().each(function () {
                isFixed |= $(this).css('position') == 'fixed';
            });
            if (isFixed && $.browser.opera) { // correction for Opera when fixed and scrolled
                $.datepicker._pos[0] -= document.documentElement.scrollLeft;
                $.datepicker._pos[1] -= document.documentElement.scrollTop;
            }
            inst._datepickerDiv.css('position', ($.datepicker._inDialog && $.blockUI ?
                    'static' : (isFixed ? 'fixed' : 'absolute')))
                .css({left: $.datepicker._pos[0] + 'px', top: $.datepicker._pos[1] + 'px'});
            $.datepicker._pos = null;
            inst._rangeStart = null;
            $.datepicker._updateDatepicker(inst);
            if (!inst._inline) {
                var speed = inst._get('speed');
                var postProcess = function () {
                    $.datepicker._datepickerShowing = true;
                    $.datepicker._afterShow(inst);
                };
                var showAnim = inst._get('showAnim') || 'show';
                inst._datepickerDiv[showAnim](speed, postProcess);
                if (speed == '')
                    postProcess();
                if (inst._input[0].type != 'hidden')
                    inst._input[0].focus();
                $.datepicker._curInst = inst;
            }
        },

        /* Generate the date picker content. */
        _updateDatepicker: function (inst) {
            inst._datepickerDiv.empty().append(inst._generateDatepicker());
            var numMonths = inst._getNumberOfMonths();
            if (numMonths[0] != 1 || numMonths[1] != 1)
                inst._datepickerDiv.addClass('datepicker_multi');
            else
                inst._datepickerDiv.removeClass('datepicker_multi');

            if (inst._get('isRTL'))
                inst._datepickerDiv.addClass('datepicker_rtl');
            else
                inst._datepickerDiv.removeClass('datepicker_rtl');

            if (inst._input && inst._input[0].type != 'hidden')
                inst._input[0].focus();
        },

        /* Tidy up after displaying the date picker. */
        _afterShow: function (inst) {
            var numMonths = inst._getNumberOfMonths(); // fix width for dynamic number of date pickers
            inst._datepickerDiv.width(numMonths[1] * $('.datepicker', inst._datepickerDiv[0])[0].offsetWidth);
            if ($.browser.msie && parseInt($.browser.version) < 7) { // fix IE < 7 select problems
                $('#datepicker_cover').css({
                    width: inst._datepickerDiv.width() + 4,
                    height: inst._datepickerDiv.height() + 4
                });
            }
            // re-position on screen if necessary
            var isFixed = inst._datepickerDiv.css('position') == 'fixed';
            var pos = inst._input ? $.datepicker._findPos(inst._input[0]) : null;
            var browserWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
            var browserHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
            var scrollX = (isFixed ? 0 : document.documentElement.scrollLeft || document.body.scrollLeft);
            var scrollY = (isFixed ? 0 : document.documentElement.scrollTop || document.body.scrollTop);
            // reposition date picker horizontally if outside the browser window
            if ((inst._datepickerDiv.offset().left + inst._datepickerDiv.width() -
                (isFixed && $.browser.msie ? document.documentElement.scrollLeft : 0)) >
                (browserWidth + scrollX)) {
                inst._datepickerDiv.css('left', Math.max(scrollX,
                        pos[0] + (inst._input ? $(inst._input[0]).width() : null) - inst._datepickerDiv.width() -
                        (isFixed && $.browser.opera ? document.documentElement.scrollLeft : 0)) + 'px');
            }
            // reposition date picker vertically if outside the browser window
            if ((inst._datepickerDiv.offset().top + inst._datepickerDiv.height() -
                (isFixed && $.browser.msie ? document.documentElement.scrollTop : 0)) >
                (browserHeight + scrollY)) {
                inst._datepickerDiv.css('top', Math.max(scrollY,
                        pos[1] - (this._inDialog ? 0 : inst._datepickerDiv.height()) -
                        (isFixed && $.browser.opera ? document.documentElement.scrollTop : 0)) + 'px');
            }
        },

        /* Find an object's position on the screen. */
        _findPos: function (obj) {
            while (obj && (obj.type == 'hidden' || obj.nodeType != 1)) {
                obj = obj.nextSibling;
            }
            var position = $(obj).offset();
            return [position.left, position.top];
        },

        /* Hide the date picker from view.
         @param  input  element - the input field attached to the date picker
         @param  speed  string - the speed at which to close the date picker */
        _hideDatepicker: function (input, speed) {
            var inst = this._curInst;
            if (!inst)
                return;
            var rangeSelect = inst._get('rangeSelect');
            if (rangeSelect && this._stayOpen) {
                this._selectDate(inst, inst._formatDate(
                    inst._currentDay, inst._currentMonth, inst._currentYear));
            }
            this._stayOpen = false;
            if (this._datepickerShowing) {
                speed = (speed != null ? speed : inst._get('speed'));
                var showAnim = inst._get('showAnim');
                inst._datepickerDiv[(showAnim == 'slideDown' ? 'slideUp' :
                    (showAnim == 'fadeIn' ? 'fadeOut' : 'hide'))](speed, function () {
                    $.datepicker._tidyDialog(inst);
                });
                if (speed == '')
                    this._tidyDialog(inst);
                var onClose = inst._get('onClose');
                if (onClose) {
                    onClose.apply((inst._input ? inst._input[0] : null),
                        [inst._getDate(), inst]);  // trigger custom callback
                }
                this._datepickerShowing = false;
                this._lastInput = null;
                inst._settings.prompt = null;
                if (this._inDialog) {
                    this._dialogInput.css({position: 'absolute', left: '0', top: '-100px'});
                    if ($.blockUI) {
                        $.unblockUI();
                        $('body').append(this._datepickerDiv);
                    }
                }
                this._inDialog = false;
            }
            this._curInst = null;
        },

        /* Tidy up after a dialog display. */
        _tidyDialog: function (inst) {
            inst._datepickerDiv.removeClass('datepicker_dialog').unbind('.datepicker');
            $('.datepicker_prompt', inst._datepickerDiv).remove();
        },

        /* Close date picker if clicked elsewhere. */
        _checkExternalClick: function (event) {
            if (!$.datepicker._curInst)
                return;
            var $target = $(event.target);
            if (($target.parents("#datepicker_div").length == 0) &&
                ($target.attr('class') != 'datepicker_trigger') &&
                $.datepicker._datepickerShowing && !($.datepicker._inDialog && $.blockUI)) {
                $.datepicker._hideDatepicker(null, '');
            }
        },

        /* Adjust one of the date sub-fields. */
        _adjustDate: function (id, offset, period) {
            var inst = this._getInst(id);
            inst._adjustDate(offset, period);
            this._updateDatepicker(inst);
        },

        /* Action for current link. */
        _gotoToday: function (id) {
            var date = new Date();
            var inst = this._getInst(id);
            inst._selectedDay = date.getDate();
            inst._drawMonth = inst._selectedMonth = date.getMonth();
            inst._drawYear = inst._selectedYear = date.getFullYear();
            this._adjustDate(inst);
        },

        /* Action for selecting a new month/year. */
        _selectMonthYear: function (id, select, period) {
            var inst = this._getInst(id);
            inst._selectingMonthYear = false;
            inst[period == 'M' ? '_drawMonth' : '_drawYear'] =
                select.options[select.selectedIndex].value - 0;
            this._adjustDate(inst);
        },

        /* Restore input focus after not changing month/year. */
        _clickMonthYear: function (id) {
            var inst = this._getInst(id);
            if (inst._input && inst._selectingMonthYear && !$.browser.msie)
                inst._input[0].focus();
            inst._selectingMonthYear = !inst._selectingMonthYear;
        },

        /* Action for changing the first week day. */
        _changeFirstDay: function (id, day) {
            var inst = this._getInst(id);
            inst._settings.firstDay = day;
            this._updateDatepicker(inst);
        },

        /* Action for selecting a day. */
        _selectDay: function (id, month, year, td) {
            if ($(td).is('.datepicker_unselectable'))
                return;
            var inst = this._getInst(id);
            var rangeSelect = inst._get('rangeSelect');
            if (rangeSelect) {
                if (!this._stayOpen) {
                    $('.datepicker td').removeClass('datepicker_currentDay');
                    $(td).addClass('datepicker_currentDay');
                }
                this._stayOpen = !this._stayOpen;
            }
            inst._selectedDay = inst._currentDay = $('a', td).html();
            inst._selectedMonth = inst._currentMonth = month;
            inst._selectedYear = inst._currentYear = year;
            this._selectDate(id, inst._formatDate(
                inst._currentDay, inst._currentMonth, inst._currentYear));
            if (this._stayOpen) {
                inst._endDay = inst._endMonth = inst._endYear = null;
                inst._rangeStart = new Date(inst._currentYear, inst._currentMonth, inst._currentDay);
                this._updateDatepicker(inst);
            }
            else if (rangeSelect) {
                inst._endDay = inst._currentDay;
                inst._endMonth = inst._currentMonth;
                inst._endYear = inst._currentYear;
                inst._selectedDay = inst._currentDay = inst._rangeStart.getDate();
                inst._selectedMonth = inst._currentMonth = inst._rangeStart.getMonth();
                inst._selectedYear = inst._currentYear = inst._rangeStart.getFullYear();
                inst._rangeStart = null;
                if (inst._inline)
                    this._updateDatepicker(inst);
            }
        },

        /* Erase the input field and hide the date picker. */
        _clearDate: function (id) {
            var inst = this._getInst(id);
            if (inst._get('mandatory'))
                return;
            this._stayOpen = false;
            inst._endDay = inst._endMonth = inst._endYear = inst._rangeStart = null;
            this._selectDate(inst, '');
        },

        /* Update the input field with the selected date. */
        _selectDate: function (id, dateStr) {
            var inst = this._getInst(id);
            dateStr = (dateStr != null ? dateStr : inst._formatDate());
            if (inst._rangeStart)
                dateStr = inst._formatDate(inst._rangeStart) + inst._get('rangeSeparator') + dateStr;
            if (inst._input)
                inst._input.val(dateStr);
            var onSelect = inst._get('onSelect');
            if (onSelect)
                onSelect.apply((inst._input ? inst._input[0] : null), [dateStr, inst]);  // trigger custom callback
            else if (inst._input)
                inst._input.trigger('change'); // fire the change event
            if (inst._inline)
                this._updateDatepicker(inst);
            else if (!this._stayOpen) {
                this._hideDatepicker(null, inst._get('speed'));
                this._lastInput = inst._input[0];
                if (typeof(inst._input[0]) != 'object')
                    inst._input[0].focus(); // restore focus
                this._lastInput = null;
            }
        },

        /* Set as beforeShowDay function to prevent selection of weekends.
         @param  date  Date - the date to customise
         @return [boolean, string] - is this date selectable?, what is its CSS class? */
        noWeekends: function (date) {
            var day = date.getDay();
            return [(day > 0 && day < 6), ''];
        },

        /* Set as calculateWeek to determine the week of the year based on the ISO 8601 definition.
         @param  date  Date - the date to get the week for
         @return  number - the number of the week within the year that contains this date */
        iso8601Week: function (date) {
            var checkDate = new Date(date.getFullYear(), date.getMonth(), date.getDate(), (date.getTimezoneOffset() / -60));
            var firstMon = new Date(checkDate.getFullYear(), 1 - 1, 4); // First week always contains 4 Jan
            var firstDay = firstMon.getDay() || 7; // Day of week: Mon = 1, ..., Sun = 7
            firstMon.setDate(firstMon.getDate() + 1 - firstDay); // Preceding Monday
            if (firstDay < 4 && checkDate < firstMon) { // Adjust first three days in year if necessary
                checkDate.setDate(checkDate.getDate() - 3); // Generate for previous year
                return $.datepicker.iso8601Week(checkDate);
            } else if (checkDate > new Date(checkDate.getFullYear(), 12 - 1, 28)) { // Check last three days in year
                firstDay = new Date(checkDate.getFullYear() + 1, 1 - 1, 4).getDay() || 7;
                if (firstDay > 4 && (checkDate.getDay() || 7) < firstDay - 3) { // Adjust if necessary
                    checkDate.setDate(checkDate.getDate() + 3); // Generate for next year
                    return $.datepicker.iso8601Week(checkDate);
                }
            }
            return Math.floor(((checkDate - firstMon) / 86400000) / 7) + 1; // Weeks to given date
        },

        /* Provide status text for a particular date.
         @param  date  the date to get the status for
         @param  inst  the current datepicker instance
         @return  the status display text for this date */
        dateStatus: function (date, inst) {
            return $.datepicker.formatDate(inst._get('dateStatus'), date, inst._getFormatConfig());
        },

        /* Parse a string value into a date object.
         The format can be combinations of the following:
         d  - day of month (no leading zero)
         dd - day of month (two digit)
         D  - day name short
         DD - day name long
         m  - month of year (no leading zero)
         mm - month of year (two digit)
         M  - month name short
         MM - month name long
         y  - year (two digit)
         yy - year (four digit)
         '...' - literal text
         '' - single quote

         @param  format           String - the expected format of the date
         @param  value            String - the date in the above format
         @param  settings  Object - attributes include:
         shortYearCutoff  Number - the cutoff year for determining the century (optional)
         dayNamesShort    String[7] - abbreviated names of the days from Sunday (optional)
         dayNames         String[7] - names of the days from Sunday (optional)
         monthNamesShort  String[12] - abbreviated names of the months (optional)
         monthNames       String[12] - names of the months (optional)
         @return  Date - the extracted date value or null if value is blank */
        parseDate: function (format, value, settings) {
            if (format == null || value == null)
                throw 'Invalid arguments';
            value = (typeof value == 'object' ? value.toString() : value + '');
            if (value == '')
                return null;
            var shortYearCutoff = (settings ? settings.shortYearCutoff : null) || this._defaults.shortYearCutoff;
            var dayNamesShort = (settings ? settings.dayNamesShort : null) || this._defaults.dayNamesShort;
            var dayNames = (settings ? settings.dayNames : null) || this._defaults.dayNames;
            var monthNamesShort = (settings ? settings.monthNamesShort : null) || this._defaults.monthNamesShort;
            var monthNames = (settings ? settings.monthNames : null) || this._defaults.monthNames;
            var year = -1;
            var month = -1;
            var day = -1;
            var literal = false;
            // Check whether a format character is doubled
            var lookAhead = function (match) {
                var matches = (iFormat + 1 < format.length && format.charAt(iFormat + 1) == match);
                if (matches)
                    iFormat++;
                return matches;
            };
            // Extract a number from the string value
            var getNumber = function (match) {
                lookAhead(match);
                var size = (match == 'y' ? 4 : 2);
                var num = 0;
                while (size > 0 && iValue < value.length &&
                value.charAt(iValue) >= '0' && value.charAt(iValue) <= '9') {
                    num = num * 10 + (value.charAt(iValue++) - 0);
                    size--;
                }
                if (size == (match == 'y' ? 4 : 2))
                    throw 'Missing number at position ' + iValue;
                return num;
            };
            // Extract a name from the string value and convert to an index
            var getName = function (match, shortNames, longNames) {
                var names = (lookAhead(match) ? longNames : shortNames);
                var size = 0;
                for (var j = 0; j < names.length; j++)
                    size = Math.max(size, names[j].length);
                var name = '';
                var iInit = iValue;
                while (size > 0 && iValue < value.length) {
                    name += value.charAt(iValue++);
                    for (var i = 0; i < names.length; i++)
                        if (name == names[i])
                            return i + 1;
                    size--;
                }
                throw 'Unknown name at position ' + iInit;
            };
            // Confirm that a literal character matches the string value
            var checkLiteral = function () {
                if (value.charAt(iValue) != format.charAt(iFormat))
                    throw 'Unexpected literal at position ' + iValue;
                iValue++;
            };
            var iValue = 0;
            for (var iFormat = 0; iFormat < format.length; iFormat++) {
                if (literal)
                    if (format.charAt(iFormat) == "'" && !lookAhead("'"))
                        literal = false;
                    else
                        checkLiteral();
                else
                    switch (format.charAt(iFormat)) {
                        case 'd':
                            day = getNumber('d');
                            break;
                        case 'D':
                            getName('D', dayNamesShort, dayNames);
                            break;
                        case 'm':
                            month = getNumber('m');
                            break;
                        case 'M':
                            month = getName('M', monthNamesShort, monthNames);
                            break;
                        case 'y':
                            year = getNumber('y');
                            break;
                        case "'":
                            if (lookAhead("'"))
                                checkLiteral();
                            else
                                literal = true;
                            break;
                        default:
                            checkLiteral();
                    }
            }
            if (year < 100) {
                year += new Date().getFullYear() - new Date().getFullYear() % 100 +
                    (year <= shortYearCutoff ? 0 : -100);
            }
            var date = new Date(year, month - 1, day);
            if (date.getFullYear() != year || date.getMonth() + 1 != month || date.getDate() != day) {
                throw 'Invalid date'; // E.g. 31/02/*
            }
            return date;
        },

        /* Format a date object into a string value.
         The format can be combinations of the following:
         d  - day of month (no leading zero)
         dd - day of month (two digit)
         D  - day name short
         DD - day name long
         m  - month of year (no leading zero)
         mm - month of year (two digit)
         M  - month name short
         MM - month name long
         y  - year (two digit)
         yy - year (four digit)
         '...' - literal text
         '' - single quote

         @param  format    String - the desired format of the date
         @param  date      Date - the date value to format
         @param  settings  Object - attributes include:
         dayNamesShort    String[7] - abbreviated names of the days from Sunday (optional)
         dayNames         String[7] - names of the days from Sunday (optional)
         monthNamesShort  String[12] - abbreviated names of the months (optional)
         monthNames       String[12] - names of the months (optional)
         @return  String - the date in the above format */
        formatDate: function (format, date, settings) {
            if (!date)
                return '';
            var dayNamesShort = (settings ? settings.dayNamesShort : null) || this._defaults.dayNamesShort;
            var dayNames = (settings ? settings.dayNames : null) || this._defaults.dayNames;
            var monthNamesShort = (settings ? settings.monthNamesShort : null) || this._defaults.monthNamesShort;
            var monthNames = (settings ? settings.monthNames : null) || this._defaults.monthNames;
            // Check whether a format character is doubled
            var lookAhead = function (match) {
                var matches = (iFormat + 1 < format.length && format.charAt(iFormat + 1) == match);
                if (matches)
                    iFormat++;
                return matches;
            };
            // Format a number, with leading zero if necessary
            var formatNumber = function (match, value) {
                return (lookAhead(match) && value < 10 ? '0' : '') + value;
            };
            // Format a name, short or long as requested
            var formatName = function (match, value, shortNames, longNames) {
                return (lookAhead(match) ? longNames[value] : shortNames[value]);
            };
            var output = '';
            var literal = false;
            if (date) {
                for (var iFormat = 0; iFormat < format.length; iFormat++) {
                    if (literal)
                        if (format.charAt(iFormat) == "'" && !lookAhead("'"))
                            literal = false;
                        else
                            output += format.charAt(iFormat);
                    else
                        switch (format.charAt(iFormat)) {
                            case 'd':
                                output += formatNumber('d', date.getDate());
                                break;
                            case 'D':
                                output += formatName('D', date.getDay(), dayNamesShort, dayNames);
                                break;
                            case 'm':
                                output += formatNumber('m', date.getMonth() + 1);
                                break;
                            case 'M':
                                output += formatName('M', date.getMonth(), monthNamesShort, monthNames);
                                break;
                            case 'y':
                                output += (lookAhead('y') ? date.getFullYear() :
                                (date.getYear() % 100 < 10 ? '0' : '') + date.getYear() % 100);
                                break;
                            case "'":
                                if (lookAhead("'"))
                                    output += "'";
                                else
                                    literal = true;
                                break;
                            default:
                                output += format.charAt(iFormat);
                        }
                }
            }
            return output;
        },

        /* Extract all possible characters from the date format. */
        _possibleChars: function (format) {
            var chars = '';
            var literal = false;
            for (var iFormat = 0; iFormat < format.length; iFormat++)
                if (literal)
                    if (format.charAt(iFormat) == "'" && !lookAhead("'"))
                        literal = false;
                    else
                        chars += format.charAt(iFormat);
                else
                    switch (format.charAt(iFormat)) {
                        case 'd' || 'm' || 'y':
                            chars += '0123456789';
                            break;
                        case 'D' || 'M':
                            return null; // Accept anything
                        case "'":
                            if (lookAhead("'"))
                                chars += "'";
                            else
                                literal = true;
                            break;
                        default:
                            chars += format.charAt(iFormat);
                    }
            return chars;
        }
    });

    /* Individualised settings for date picker functionality applied to one or more related inputs.
     Instances are managed and manipulated through the Datepicker manager. */
    function DatepickerInstance(settings, inline) {
        this._id = $.datepicker._register(this);
        this._selectedDay = 0; // Current date for selection
        this._selectedMonth = 0; // 0-11
        this._selectedYear = 0; // 4-digit year
        this._drawMonth = 0; // Current month at start of datepicker
        this._drawYear = 0;
        this._input = null; // The attached input field
        this._inline = inline; // True if showing inline, false if used in a popup
        this._datepickerDiv = (!inline ? $.datepicker._datepickerDiv :
            $('<div id="datepicker_div_' + this._id + '" class="datepicker_inline">'));
        // customise the date picker object - uses manager defaults if not overridden
        this._settings = extendRemove(settings || {}); // clone
        if (inline)
            this._setDate(this._getDefaultDate());
    }

    $.extend(DatepickerInstance.prototype, {
        /* Get a setting value, defaulting if necessary. */
        _get: function (name) {
            return this._settings[name] || $.datepicker._defaults[name];
        },

        /* Parse existing date and initialise date picker. */
        _setDateFromField: function (input) {
            this._input = $(input);
            var dateFormat = this._get('dateFormat');
            var dates = this._input ? this._input.val().split(this._get('rangeSeparator')) : null;
            this._endDay = this._endMonth = this._endYear = null;
            var date = defaultDate = this._getDefaultDate();
            if (dates.length > 0) {
                var settings = this._getFormatConfig();
                if (dates.length > 1) {
                    date = $.datepicker.parseDate(dateFormat, dates[1], settings) || defaultDate;
                    this._endDay = date.getDate();
                    this._endMonth = date.getMonth();
                    this._endYear = date.getFullYear();
                }
                try {
                    date = $.datepicker.parseDate(dateFormat, dates[0], settings) || defaultDate;
                } catch (e) {
                    $.datepicker.log(e);
                    date = defaultDate;
                }
            }
            this._selectedDay = date.getDate();
            this._drawMonth = this._selectedMonth = date.getMonth();
            this._drawYear = this._selectedYear = date.getFullYear();
            this._currentDay = (dates[0] ? date.getDate() : 0);
            this._currentMonth = (dates[0] ? date.getMonth() : 0);
            this._currentYear = (dates[0] ? date.getFullYear() : 0);
            this._adjustDate();
        },

        /* Retrieve the default date shown on opening. */
        _getDefaultDate: function () {
            var date = this._determineDate('defaultDate', new Date());
            var minDate = this._getMinMaxDate('min', true);
            var maxDate = this._getMinMaxDate('max');
            date = (minDate && date < minDate ? minDate : date);
            date = (maxDate && date > maxDate ? maxDate : date);
            return date;
        },

        /* A date may be specified as an exact value or a relative one. */
        _determineDate: function (name, defaultDate) {
            var offsetNumeric = function (offset) {
                var date = new Date();
                date.setDate(date.getDate() + offset);
                return date;
            };
            var offsetString = function (offset, getDaysInMonth) {
                var date = new Date();
                var matches = /^([+-]?[0-9]+)\s*(d|D|w|W|m|M|y|Y)?$/.exec(offset);
                if (matches) {
                    var year = date.getFullYear();
                    var month = date.getMonth();
                    var day = date.getDate();
                    switch (matches[2] || 'd') {
                        case 'd' :
                        case 'D' :
                            day += (matches[1] - 0);
                            break;
                        case 'w' :
                        case 'W' :
                            day += (matches[1] * 7);
                            break;
                        case 'm' :
                        case 'M' :
                            month += (matches[1] - 0);
                            day = Math.min(day, getDaysInMonth(year, month));
                            break;
                        case 'y':
                        case 'Y' :
                            year += (matches[1] - 0);
                            day = Math.min(day, getDaysInMonth(year, month));
                            break;
                    }
                    date = new Date(year, month, day);
                }
                return date;
            };
            var date = this._get(name);
            return (date == null ? defaultDate :
                (typeof date == 'string' ? offsetString(date, this._getDaysInMonth) :
                    (typeof date == 'number' ? offsetNumeric(date) : date)));
        },

        /* Set the date(s) directly. */
        _setDate: function (date, endDate) {
            this._selectedDay = this._currentDay = date.getDate();
            this._drawMonth = this._selectedMonth = this._currentMonth = date.getMonth();
            this._drawYear = this._selectedYear = this._currentYear = date.getFullYear();
            if (this._get('rangeSelect')) {
                if (endDate) {
                    this._endDay = endDate.getDate();
                    this._endMonth = endDate.getMonth();
                    this._endYear = endDate.getFullYear();
                } else {
                    this._endDay = this._currentDay;
                    this._endMonth = this._currentMonth;
                    this._endYear = this._currentYear;
                }
            }
            this._adjustDate();
        },

        /* Retrieve the date(s) directly. */
        _getDate: function () {
            var startDate = (!this._currentYear || (this._input && this._input.val() == '') ? null :
                new Date(this._currentYear, this._currentMonth, this._currentDay));
            if (this._get('rangeSelect')) {
                return [startDate, (!this._endYear ? null :
                    new Date(this._endYear, this._endMonth, this._endDay))];
            } else
                return startDate;
        },

        /* Generate the HTML for the current state of the date picker. */
        _generateDatepicker: function () {
            var today = new Date();
            today = new Date(today.getFullYear(), today.getMonth(), today.getDate()); // clear time
            var showStatus = this._get('showStatus');
            var isRTL = this._get('isRTL');
            // build the date picker HTML
            var clear = (this._get('mandatory') ? '' :
            '<div class="datepicker_clear"><a onclick="jQuery.datepicker._clearDate(' + this._id + ');"' +
            (showStatus ? this._addStatus(this._get('clearStatus') || '&#xa0;') : '') + '>' +
            this._get('clearText') + '</a></div>');
            var controls = '<div class="datepicker_control">' + (isRTL ? '' : clear) +
                '<div class="datepicker_close"><a onclick="jQuery.datepicker._hideDatepicker();"' +
                (showStatus ? this._addStatus(this._get('closeStatus') || '&#xa0;') : '') + '>' +
                this._get('closeText') + '</a></div>' + (isRTL ? clear : '') + '</div>';
            var prompt = this._get('prompt');
            var closeAtTop = this._get('closeAtTop');
            var hideIfNoPrevNext = this._get('hideIfNoPrevNext');
            var numMonths = this._getNumberOfMonths();
            var stepMonths = this._get('stepMonths');
            var isMultiMonth = (numMonths[0] != 1 || numMonths[1] != 1);
            var minDate = this._getMinMaxDate('min', true);
            var maxDate = this._getMinMaxDate('max');
            var drawMonth = this._drawMonth;
            var drawYear = this._drawYear;
            if (maxDate) {
                var maxDraw = new Date(maxDate.getFullYear(),
                    maxDate.getMonth() - numMonths[1] + 1, maxDate.getDate());
                maxDraw = (minDate && maxDraw < minDate ? minDate : maxDraw);
                while (new Date(drawYear, drawMonth, 1) > maxDraw) {
                    drawMonth--;
                    if (drawMonth < 0) {
                        drawMonth = 11;
                        drawYear--;
                    }
                }
            }
            // controls and links
            var prev = '<div class="datepicker_prev">' + (this._canAdjustMonth(-1, drawYear, drawMonth) ?
                '<a onclick="jQuery.datepicker._adjustDate(' + this._id + ', -' + stepMonths + ', \'M\');"' +
                (showStatus ? this._addStatus(this._get('prevStatus') || '&#xa0;') : '') + '>' +
                this._get('prevText') + '</a>' :
                    (hideIfNoPrevNext ? '' : '<label>' + this._get('prevText') + '</label>')) + '</div>';
            var next = '<div class="datepicker_next">' + (this._canAdjustMonth(+1, drawYear, drawMonth) ?
                '<a onclick="jQuery.datepicker._adjustDate(' + this._id + ', +' + stepMonths + ', \'M\');"' +
                (showStatus ? this._addStatus(this._get('nextStatus') || '&#xa0;') : '') + '>' +
                this._get('nextText') + '</a>' :
                    (hideIfNoPrevNext ? '>' : '<label>' + this._get('nextText') + '</label>')) + '</div>';
            var html = (prompt ? '<div class="datepicker_prompt">' + prompt + '</div>' : '') +
                (closeAtTop && !this._inline ? controls : '') +
                '<div class="datepicker_links">' + (isRTL ? next : prev) +
                (this._isInRange(today) ? '<div class="datepicker_current">' +
                '<a onclick="jQuery.datepicker._gotoToday(' + this._id + ');"' +
                (showStatus ? this._addStatus(this._get('currentStatus') || '&#xa0;') : '') + '>' +
                this._get('currentText') + '</a></div>' : '') + (isRTL ? prev : next) + '</div>';
            var showWeeks = this._get('showWeeks');
            for (var row = 0; row < numMonths[0]; row++)
                for (var col = 0; col < numMonths[1]; col++) {
                    var selectedDate = new Date(drawYear, drawMonth, this._selectedDay);
                    html += '<div class="datepicker_oneMonth' + (col == 0 ? ' datepicker_newRow' : '') + '">' +
                        this._generateMonthYearHeader(drawMonth, drawYear, minDate, maxDate,
                            selectedDate, row > 0 || col > 0) + // draw month headers
                        '<table class="datepicker" cellpadding="0" cellspacing="0"><thead>' +
                        '<tr class="datepicker_titleRow">' +
                        (showWeeks ? '<td>' + this._get('weekHeader') + '</td>' : '');
                    var firstDay = this._get('firstDay');
                    var changeFirstDay = this._get('changeFirstDay');
                    var dayNames = this._get('dayNames');
                    var dayNamesShort = this._get('dayNamesShort');
                    var dayNamesMin = this._get('dayNamesMin');
                    for (var dow = 0; dow < 7; dow++) { // days of the week
                        var day = (dow + firstDay) % 7;
                        var status = this._get('dayStatus') || '&#xa0;';
                        status = (status.indexOf('DD') > -1 ? status.replace(/DD/, dayNames[day]) :
                            status.replace(/D/, dayNamesShort[day]));
                        html += '<td' + ((dow + firstDay + 6) % 7 >= 5 ? ' class="datepicker_weekEndCell"' : '') + '>' +
                            (!changeFirstDay ? '<span' :
                            '<a onclick="jQuery.datepicker._changeFirstDay(' + this._id + ', ' + day + ');"') +
                            (showStatus ? this._addStatus(status) : '') + ' title="' + dayNames[day] + '">' +
                            dayNamesMin[day] + (changeFirstDay ? '</a>' : '</span>') + '</td>';
                    }
                    html += '</tr></thead><tbody>';
                    var daysInMonth = this._getDaysInMonth(drawYear, drawMonth);
                    if (drawYear == this._selectedYear && drawMonth == this._selectedMonth) {
                        this._selectedDay = Math.min(this._selectedDay, daysInMonth);
                    }
                    var leadDays = (this._getFirstDayOfMonth(drawYear, drawMonth) - firstDay + 7) % 7;
                    var currentDate = (!this._currentDay ? new Date(9999, 9, 9) :
                        new Date(this._currentYear, this._currentMonth, this._currentDay));
                    var endDate = this._endDay ? new Date(this._endYear, this._endMonth, this._endDay) : currentDate;
                    var printDate = new Date(drawYear, drawMonth, 1 - leadDays);
                    var numRows = (isMultiMonth ? 6 : Math.ceil((leadDays + daysInMonth) / 7)); // calculate the number of rows to generate
                    var beforeShowDay = this._get('beforeShowDay');
                    var showOtherMonths = this._get('showOtherMonths');
                    var calculateWeek = this._get('calculateWeek') || $.datepicker.iso8601Week;
                    var dateStatus = this._get('statusForDate') || $.datepicker.dateStatus;
                    for (var dRow = 0; dRow < numRows; dRow++) { // create date picker rows
                        html += '<tr class="datepicker_daysRow">' +
                            (showWeeks ? '<td class="datepicker_weekCol">' + calculateWeek(printDate) + '</td>' : '');
                        for (var dow = 0; dow < 7; dow++) { // create date picker days
                            var daySettings = (beforeShowDay ?
                                beforeShowDay.apply((this._input ? this._input[0] : null), [printDate]) : [true, '']);
                            var otherMonth = (printDate.getMonth() != drawMonth);
                            var unselectable = otherMonth || !daySettings[0] ||
                                (minDate && printDate < minDate) || (maxDate && printDate > maxDate);
                            html += '<td class="datepicker_daysCell' +
                                ((dow + firstDay + 6) % 7 >= 5 ? ' datepicker_weekEndCell' : '') + // highlight weekends
                                (otherMonth ? ' datepicker_otherMonth' : '') + // highlight days from other months
                                (printDate.getTime() == selectedDate.getTime() && drawMonth == this._selectedMonth ?
                                    ' datepicker_daysCellOver' : '') + // highlight selected day
                                (unselectable ? ' datepicker_unselectable' : '') +  // highlight unselectable days
                                (otherMonth && !showOtherMonths ? '' : ' ' + daySettings[1] + // highlight custom dates
                                (printDate.getTime() >= currentDate.getTime() && printDate.getTime() <= endDate.getTime() ?  // in current range
                                    ' datepicker_currentDay' : '') + // highlight selected day
                                (printDate.getTime() == today.getTime() ? ' datepicker_today' : '')) + '"' + // highlight today (if different)
                                (unselectable ? '' : ' onmouseover="jQuery(this).addClass(\'datepicker_daysCellOver\');' +
                                (!showStatus || (otherMonth && !showOtherMonths) ? '' : 'jQuery(\'#datepicker_status_' +
                                this._id + '\').html(\'' + (dateStatus.apply((this._input ? this._input[0] : null),
                                    [printDate, this]) || '&#xa0;') + '\');') + '"' +
                                ' onmouseout="jQuery(this).removeClass(\'datepicker_daysCellOver\');' +
                                (!showStatus || (otherMonth && !showOtherMonths) ? '' : 'jQuery(\'#datepicker_status_' +
                                this._id + '\').html(\'&#xa0;\');') + '" onclick="jQuery.datepicker._selectDay(' +
                                this._id + ',' + drawMonth + ',' + drawYear + ', this);"') + '>' + // actions
                                (otherMonth ? (showOtherMonths ? printDate.getDate() : '&#xa0;') : // display for other months
                                    (unselectable ? printDate.getDate() : '<a>' + printDate.getDate() + '</a>')) + '</td>'; // display for this month
                            printDate.setDate(printDate.getDate() + 1);
                        }
                        html += '</tr>';
                    }
                    drawMonth++;
                    if (drawMonth > 11) {
                        drawMonth = 0;
                        drawYear++;
                    }
                    html += '</tbody></table></div>';
                }
            html += (showStatus ? '<div id="datepicker_status_' + this._id +
                '" class="datepicker_status">' + (this._get('initStatus') || '&#xa0;') + '</div>' : '') +
                (!closeAtTop && !this._inline ? controls : '') +
                '<div style="clear: both;"></div>' +
                ($.browser.msie && parseInt($.browser.version) < 7 && !this._inline ?
                    '<iframe src="javascript:false;" class="datepicker_cover"></iframe>' : '');
            return html;
        },

        /* Generate the month and year header. */
        _generateMonthYearHeader: function (drawMonth, drawYear, minDate, maxDate, selectedDate, secondary) {
            minDate = (this._rangeStart && minDate && selectedDate < minDate ? selectedDate : minDate);
            var showStatus = this._get('showStatus');
            var html = '<div class="datepicker_header">';
            // month selection
            var monthNames = this._get('monthNames');
            if (secondary || !this._get('changeMonth'))
                html += monthNames[drawMonth] + '&#xa0;';

            else {
                var inMinYear = (minDate && minDate.getFullYear() == drawYear);
                var inMaxYear = (maxDate && maxDate.getFullYear() == drawYear);
                html += '<select class="datepicker_newMonth" ' +
                    'onchange="jQuery.datepicker._selectMonthYear(' + this._id + ', this, \'M\');" ' +
                    'onclick="jQuery.datepicker._clickMonthYear(' + this._id + ');"' +
                    (showStatus ? this._addStatus(this._get('monthStatus') || '&#xa0;') : '') + '>';
                for (var month = 0; month < 12; month++) {
                    if ((!inMinYear || month >= minDate.getMonth()) &&
                        (!inMaxYear || month <= maxDate.getMonth())) {
                        html += '<option value="' + month + '"' +
                            (month == drawMonth ? ' selected="selected"' : '') +
                            '>' + monthNames[month] + '</option>';
                    }
                }
                html += '</select>';
            }
            // year selection
            if (secondary || !this._get('changeYear'))
                html += drawYear;
            else {
                // determine range of years to display
                var years = this._get('yearRange').split(':');
                var year = 0;
                var endYear = 0;
                if (years.length != 2) {
                    year = drawYear - 30;
                    endYear = drawYear + 10;
                } else if (years[0].charAt(0) == '+' || years[0].charAt(0) == '-') {
                    year = drawYear + parseInt(years[0], 30);
                    endYear = drawYear + parseInt(years[1], 10);
                } else {
                    year = parseInt(years[0], 30);
                    endYear = parseInt(years[1], 10);
                }
                year = (minDate ? Math.max(year, minDate.getFullYear()) : year);
                endYear = (maxDate ? Math.min(endYear, maxDate.getFullYear()) : endYear);
                html += '<select class="datepicker_newYear" ' +
                    'onchange="jQuery.datepicker._selectMonthYear(' + this._id + ', this, \'Y\');" ' +
                    'onclick="jQuery.datepicker._clickMonthYear(' + this._id + ');"' +
                    (showStatus ? this._addStatus(this._get('yearStatus') || '&#xa0;') : '') + '>';
                for (; year <= endYear; year++) {
                    html += '<option value="' + year + '"' +
                        (year == drawYear ? ' selected="selected"' : '') +
                        '>' + year + '</option>';
                }
                html += '</select>';
            }
            html += '</div>'; // Close datepicker_header
            return html;
        },

        /* Provide code to set and clear the status panel. */
        _addStatus: function (text) {
            return ' onmouseover="jQuery(\'#datepicker_status_' + this._id + '\').html(\'' + text + '\');" ' +
                'onmouseout="jQuery(\'#datepicker_status_' + this._id + '\').html(\'&#xa0;\');"';
        },

        /* Adjust one of the date sub-fields. */
        _adjustDate: function (offset, period) {
            var year = this._drawYear + (period == 'Y' ? offset : 0);
            var month = this._drawMonth + (period == 'M' ? offset : 0);
            var day = Math.min(this._selectedDay, this._getDaysInMonth(year, month)) +
                (period == 'D' ? offset : 0);
            var date = new Date(year, month, day);
            // ensure it is within the bounds set
            var minDate = this._getMinMaxDate('min', true);
            var maxDate = this._getMinMaxDate('max');
            date = (minDate && date < minDate ? minDate : date);
            date = (maxDate && date > maxDate ? maxDate : date);
            this._selectedDay = date.getDate();
            this._drawMonth = this._selectedMonth = date.getMonth();
            this._drawYear = this._selectedYear = date.getFullYear();
        },

        /* Determine the number of months to show. */
        _getNumberOfMonths: function () {
            var numMonths = this._get('numberOfMonths');
            return (numMonths == null ? [1, 1] : (typeof numMonths == 'number' ? [1, numMonths] : numMonths));
        },

        /* Determine the current maximum date - ensure no time components are set - may be overridden for a range. */
        _getMinMaxDate: function (minMax, checkRange) {
            var date = this._determineDate(minMax + 'Date', null);
            if (date) {
                date.setHours(0);
                date.setMinutes(0);
                date.setSeconds(0);
                date.setMilliseconds(0);
            }
            return date || (checkRange ? this._rangeStart : null);
        },

        /* Find the number of days in a given month. */
        _getDaysInMonth: function (year, month) {
            return 32 - new Date(year, month, 32).getDate();
        },

        /* Find the day of the week of the first of a month. */
        _getFirstDayOfMonth: function (year, month) {
            return new Date(year, month, 1).getDay();
        },

        /* Determines if we should allow a "next/prev" month display change. */
        _canAdjustMonth: function (offset, curYear, curMonth) {
            var numMonths = this._getNumberOfMonths();
            var date = new Date(curYear, curMonth + (offset < 0 ? offset : numMonths[1]), 1);
            if (offset < 0)
                date.setDate(this._getDaysInMonth(date.getFullYear(), date.getMonth()));
            return this._isInRange(date);
        },

        /* Is the given date in the accepted range? */
        _isInRange: function (date) {
            // during range selection, use minimum of selected date and range start
            var newMinDate = (!this._rangeStart ? null :
                new Date(this._selectedYear, this._selectedMonth, this._selectedDay));
            newMinDate = (newMinDate && this._rangeStart < newMinDate ? this._rangeStart : newMinDate);
            var minDate = newMinDate || this._getMinMaxDate('min');
            var maxDate = this._getMinMaxDate('max');
            return ((!minDate || date >= minDate) && (!maxDate || date <= maxDate));
        },

        /* Provide the configuration settings for formatting/parsing. */
        _getFormatConfig: function () {
            var shortYearCutoff = this._get('shortYearCutoff');
            shortYearCutoff = (typeof shortYearCutoff != 'string' ? shortYearCutoff :
            new Date().getFullYear() % 100 + parseInt(shortYearCutoff, 10));
            return {
                shortYearCutoff: shortYearCutoff,
                dayNamesShort: this._get('dayNamesShort'), dayNames: this._get('dayNames'),
                monthNamesShort: this._get('monthNamesShort'), monthNames: this._get('monthNames')
            };
        },

        /* Format the given date for display. */
        _formatDate: function (day, month, year) {
            if (!day) {
                this._currentDay = this._selectedDay;
                this._currentMonth = this._selectedMonth;
                this._currentYear = this._selectedYear;
            }
            var date = (day ? (typeof day == 'object' ? day : new Date(year, month, day)) :
                new Date(this._currentYear, this._currentMonth, this._currentDay));
            return $.datepicker.formatDate(this._get('dateFormat'), date, this._getFormatConfig());
        }
    });

    /* jQuery extend now ignores nulls! */
    function extendRemove(target, props) {
        $.extend(target, props);
        for (var name in props)
            if (props[name] == null)
                target[name] = null;
        return target;
    };

    /* Invoke the datepicker functionality.
     @param  options  String - a command, optionally followed by additional parameters or
     Object - settings for attaching new datepicker functionality
     @return  jQuery object */
    $.fn.datepicker = function (options) {
        var otherArgs = Array.prototype.slice.call(arguments, 1);
        if (typeof options == 'string' && (options == 'isDisabled' || options == 'getDate')) {
            return $.datepicker['_' + options + 'Datepicker'].apply($.datepicker, [this[0]].concat(otherArgs));
        }
        return this.each(function () {
            typeof options == 'string' ?
                $.datepicker['_' + options + 'Datepicker'].apply($.datepicker, [this].concat(otherArgs)) :
                $.datepicker._attachDatepicker(this, options);
        });
    };

    /* Initialise the date picker. */
    $(document).ready(function () {
        $(document.body).append($.datepicker._datepickerDiv)
            .mousedown($.datepicker._checkExternalClick);
    });

    $.datepicker = new Datepicker(); // singleton instance

})(jQuery);
$(function ($) {
    $.datepicker.regional['zh-CN'] = {
        clearText: '清除',
        clearStatus: '清除已选日期',
        closeText: '关闭',
        closeStatus: '不改变当前选择',
        prevText: '&lt;上月',
        prevStatus: '显示上月',
        nextText: '下月&gt;',
        nextStatus: '显示下月',
        currentText: '今天',
        currentStatus: '显示本月',
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月',
            '十月', '十一月', '十二月'],
        monthNamesShort: ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十',
            '十一', '十二'],
        monthStatus: '选择月份',
        yearStatus: '选择年份',
        weekHeader: '周',
        weekStatus: '年内周次',
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
        dayStatus: '设置 DD 为一周起始',
        dateStatus: '选择 m月 d日, DD',
        dateFormat: 'yy-mm-dd',
        firstDay: 1,
        initStatus: '请选择日期',
        isRTL: false
    };
    $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
    $(".dateinput").datepicker({
        onSelect: function () {
            this.focus();
        }
    });

});


function delall() {
    if (confirm("请确认是否执行删除操作!"))
        document.getElementById("del").submit();
}
function delUrl(url) {
    if (confirm("请确认是否执行禁用操作!")) {
        window.location = url;
    }
}
function cz() {
    document.getElementById("czlist").submit();
}
$(function () {
    $(".selectCheck").click(function () {
        $(".selectCheckInput").attr("checked", $(this).attr("checked"));
    })
    $(".date").datepicker();
});


al = function () {
    alert('sss');
}

resultAjax1 = function (url, data, m_fun, type) {
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        dataType: type,
        success: function (data) {
            m_fun(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    });
}

resultAjax = function (url, data, m_fun, type) {
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        dataType: type,
        success: function (data) {
            m_fun(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("数据出错！");
        }
    });
}

m_ajax = function (url, data) {
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        timeout: 10000,
        dataType: "html",
        success: function (data) {
            if (data == "1") {
                alert("操作成功!");
                loadData(null);
            } else if (data == "0") {
                alert("操作失败!");
            }
        },
        error: function () {
        }
    });
}

m_ajax_data = function (url, data, dataType) {
    $.ajax({
        type: 'POST',
        url: url,
        data: {},
        dataType: "json",
        timeout: 10000,
        success: function (data) {
            parsetData(data[0].data);
            setPageTable(data[0].page);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    });
}


function setPageTable(page) {
    var m_tr = document.getElementById("mpage_tr");
    var mtrStr = '<div style="width:600px;height:22px;margin:auto;padding-left:180px">';
    mtrStr += '<div style="float:left;">';
    mtrStr += '<div style="float:left;">';
    if (page.totalpage > 0) {
        mtrStr += '<a href="javascript:goPageTo(\'' + (page.pageNo - 1) + '\')">';
        mtrStr += '<img src="' + projectName + '/web/jsp/admin/img/tab2_fenye_25.gif" border="0" /></a>';
    }
    mtrStr += '</div><div style="float:left"><ul>';
    var s = page.pageNo - 2;
    if (page.totalpage == page.pageNo) {
        s = page.pageNo - 4;
    }
    if (page.totalpage - 1 == page.pageNo) {
        s = page.pageNo - 3;
    }
    var e = page.totalpage;
    var pageNo = page.pageNo;
    var t = 0;
    var mtrStr1 = "";
    for (var i = 0; i < page.totalpage + 5 && t < 5; i++) {

        var si = parseInt(s + i);
        if (si > 0 && si <= parseInt(page.totalpage)) {
            t++;
            if (si == pageNo) {
                mtrStr1 = "<li>" + si + "</li>";
            } else {
                mtrStr1 = "<li><a href=\"javascript:goPageTo('" + si + "');\" class=\"zhu3\">" + si + "</a></li>";
            }
            mtrStr += mtrStr1;
        }
    }

    mtrStr += '</ul></div>';
    if (page.totalpage > 0) {
        mtrStr += '<div style="float:left;margin-left:10px">';
        mtrStr += '<a href="javascript:goPageTo(\'' + (page.pageNo + 1) + '\')">';
        mtrStr += '<img src="' + projectName + '/web/jsp/admin/img/tab2_fenye_31.gif" border="0" /></a></div>';
        mtrStr += '<div style="float:left;margin-left:10px;width:100px;margin-top:1px;"><a href="javascript:jump();">转到</a>';
        mtrStr += '<input style="width:50px;height:12px;" type="text" id="ys" value="' + page.pageNo + '">页</div>';
        mtrStr += '<div style="float:left;margin-left:10px;margin-top:5px; width:150px">';
        mtrStr += '共' + page.totalpage + '页&nbsp;';
        mtrStr += page.totalcount + '条数据</div>';
    } else {
        mtrStr += "占无数据";
    }
    mtrStr += '</div></td></tr>';
    m_tr.cells[0].innerHTML = mtrStr;

}

var currentindex = -1;
var size = 0;
function movethis(up) {
    currentindex = currentindex + (up ? -1 : 1);
    if (currentindex == size) {
        currentindex = 0;
    }
    else if (currentindex < 0) {
        currentindex = size - 1;
    }
    $("#boxpro div").removeClass("linePro");
    $("#boxpro div").css("background-color", "");
    $($("#boxpro div")[currentindex]).addClass("linePro");
    $($("#boxpro div")[currentindex]).css("background-color", "#939393");
    // var name = $($("#boxpro div")[currentindex]).text();
    //     name = name.substring(3,name.indexOf("|"))
    //  $(window.curObj).val(name);
}
function allkeyup(e) {
    if (e.keyCode == 38) {
        movethis(true);
    }
    else if (e.keyCode == 40) {
        movethis(false);
    }
    else if (e.keyCode == 13) {
        if (currentindex != -1) {
            $("#boxpro").hide();
            $(".linePro").trigger("click");
        }
    }
}
function inputKey(name, url, key, val) {
    var curSel = {
        'url': '',
        'key': '',
        'val': '',
        'init': function (name, url, key, val) {
            curSel.name = name;
            curSel.url = url;
            curSel.key = key;
            curSel.val = val;
            if ($("#boxpro").length == 0) {
                var div = '<div id="boxpro" class="position" style="display:none;width:350px;position:absolute;z-index:300;height:600px;overflow-y:auto;overflow-x:hidden;background-color:#ffffff;padding:5px;border:#cccccc solid 2px;"></div>';
                $(window.document.body).append(div);
            }
            name.unbind("click").click(function () {
                curSel.click();
            }).unbind("keyup").keyup(function () {
                curSel.keyup();
            });

        },
        'name': '',
        'keyup': function () {
            $("#boxpro").empty();
            $("#boxpro").append("<img src='../../img/loading.gif' /><br/>数据加载中...");
            $("#boxpro").css("top", curSel.name.offset().top + 25);
            $("#boxpro").css("left", curSel.name.offset().left);
            $("#boxpro").css("display", "");
            curSel.resultAjax(url, "name=" + curSel.name.val() + "&i=" + Math.random(), "json");
        },
        'click': function () {
            $("#boxpro").empty();
            $("#boxpro").append("<img src='../../img/loading.gif' /><br/>数据加载中...");
            $("#boxpro").css("top", curSel.name.offset().top + 25);
            $("#boxpro").css("left", curSel.name.offset().left);
            $("#boxpro").css("display", "");
            curSel.resultAjax(url, "name=" + curSel.name.val() + "&i=" + Math.random(), "json");
        },
        'resultAjax': function (url, data, type) {
            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                dataType: type,
                success: function (data) {
                    curSel.userResult(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("服务器内部错误!" + textStatus);
                }
            })
        },
        'userResult': function (data) {
            $("#boxpro").empty();
            $("#boxpro").css("display", "");
            for (var i = 0; i < data.length; i++) {
                var bg = "";
                if (i % 2 > 0)
                    bg = "background-color:#939393;";
                $("#boxpro").append("<div class='linePro' id='" + data[i][curSel.val] + "' style='width:350px;height:30px;line-height:30px;" + bg + "'>" + (i + 1) + "|" + data[i][curSel.key] + "</div>");

            }
            curSel.addUserlisterentLinePro();
        },
        'addUserlisterentLinePro': function () {
            $(".linePro").click(function () {
                $("#boxpro").css("display", "none");
                $("#" + curSel.name.attr("mappendBy")).val(this.id);
                var name = $(this).text();
                curSel.name.val(name.substring(name.indexOf("|") + 1));
            });
        }
    }
    curSel.init(name, url, key, val);
}
address = function (provinceId, cityId, countyId, url) {
    var addCtl = {
        init: function (provinceId, cityId, countyId, url) {
            this.provinceId = provinceId;
            this.cityId = cityId;
            this.countyId = countyId;
            this.url = url;
            addCtl.event();

        },
        provinceId: "",
        cityId: "",
        countyId: "",
        url: "",
        event: function () {
            $("#" + provinceId).change(function () {
                addCtl.cityAjax(addCtl.url, "parentId=" + $("#" + provinceId).val() + "&i=" + Math.random(), "json");
            });
            $("#" + cityId).change(function () {
                addCtl.countyAjax(addCtl.url, "parentId=" + $("#" + cityId).val() + "&i=" + Math.random(), "json");
            });
            addCtl.provinceAjax(addCtl.url, "parentId=&i=" + Math.random(), "json");
        },
        provinceAjax: function (url, data, type) {
            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                dataType: type,
                success: function (data) {
                    addCtl.provinceResult(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("服务器内部错误!" + textStatus);
                }
            })
        },
        provinceResult: function (data) {
            $("#" + provinceId).empty();
            for (var i = 0; i < data.length; i++) {
                $("#" + provinceId).append("<option value='" + data[i].id + "' " + ($("#" + provinceId).attr("dataVal") == data[i].id ? "selected" : "") + ">" + data[i].name + "</option>");
            }
            addCtl.cityAjax(addCtl.url, "parentId=" + $("#" + provinceId).val() + "&i=" + Math.random(), "json");
        },
        cityAjax: function (url, data, type) {
            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                dataType: type,
                success: function (data) {
                    addCtl.cityResult(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("服务器内部错误!" + textStatus);
                }
            })
        },
        cityResult: function (data) {
            $("#" + cityId).empty();
            for (var i = 0; i < data.length; i++) {
                $("#" + cityId).append("<option value='" + data[i].id + "' " + ($("#" + cityId).attr("dataVal") == data[i].id ? "selected" : "") + ">" + data[i].name + "</option>");
            }
            addCtl.countyAjax(addCtl.url, "parentId=" + $("#" + cityId).val() + "&i=" + Math.random(), "json");
        },
        countyAjax: function (url, data, type) {
            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                dataType: type,
                success: function (data) {
                    addCtl.countyResult(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("服务器内部错误!" + textStatus);
                }
            })
        },
        countyResult: function (data) {
            $("#" + countyId).empty();
            for (var i = 0; i < data.length; i++) {
                $("#" + countyId).append("<option value='" + data[i].id + "' " + ($("#" + countyId).attr("dataVal") == data[i].id ? "selected" : "") + ">" + data[i].name + "</option>");
            }
        }
    }
    addCtl.init(provinceId, cityId, countyId, url);
}