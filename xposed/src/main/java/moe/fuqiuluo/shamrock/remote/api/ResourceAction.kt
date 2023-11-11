package moe.fuqiuluo.shamrock.remote.api

import io.ktor.http.ContentType
import moe.fuqiuluo.shamrock.utils.FileUtils
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.document
import io.ktor.server.response.respond
import io.ktor.server.response.respondFile
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import moe.fuqiuluo.shamrock.remote.action.handlers.*
import moe.fuqiuluo.shamrock.tools.*

private fun formatFileName(file: String): String = file
    .replace(regex = "[{}\\-]".toRegex(), replacement = "")
    .replace(" ", "")
    .split(".")[0].lowercase()

fun Routing.fetchRes() {
    getOrPost("/get_record") {
        val file = formatFileName( fetchGetOrThrow("file") )
        val format = fetchOrThrow("out_format")
        call.respondText(GetRecord(file, format), ContentType.Application.Json)
    }

    getOrPost("/get_image") {
        val file = formatFileName( fetchGetOrThrow("file") )
        call.respondText(GetImage(file), ContentType.Application.Json)
    }

    getOrPost("/upload_group_file") {
        val groupId = fetchOrThrow("group_id")
        val file = fetchOrThrow("file")
        val name = fetchOrThrow("name")
        call.respondText(UploadGroupFile(groupId, file, name), ContentType.Application.Json)
    }

    getOrPost("/upload_private_file") {
        val userId = fetchOrThrow("user_id")
        val file = fetchOrThrow("file")
        val name = fetchOrThrow("name")
        call.respondText(UploadPrivateFile(userId, file, name), ContentType.Application.Json)
    }

    getOrPost("/create_group_file_folder") {
        val groupId = fetchOrThrow("group_id")
        val name = fetchOrThrow("name")
        call.respondText(CreateGroupFileFolder(groupId, name), ContentType.Application.Json)
    }

    getOrPost("/delete_group_folder") {
        val groupId = fetchOrThrow("group_id")
        val id = fetchOrThrow("folder_id")
        call.respondText(DeleteGroupFolder(groupId, id), ContentType.Application.Json)
    }

    getOrPost("/delete_group_file") {
        val groupId = fetchOrThrow("group_id")
        val id = fetchOrThrow("file_id")
        val busid = fetchOrThrow("busid").toInt()
        call.respondText(DeleteGroupFile(groupId, id, busid), ContentType.Application.Json)
    }

    getOrPost("/get_group_file_system_info") {
        val groupId = fetchOrThrow("group_id")
        call.respondText(GetGroupFileSystemInfo(groupId), ContentType.Application.Json)
    }

    getOrPost("/get_group_root_files") {
        val groupId = fetchOrThrow("group_id")
        call.respondText(GetGroupRootFiles(groupId), ContentType.Application.Json)
    }

    getOrPost("/get_group_files_by_folder") {
        val groupId = fetchOrThrow("group_id")
        val folderId = fetchOrThrow("folder_id")
        call.respondText(GetGroupSubFiles(groupId, folderId), ContentType.Application.Json)
    }

    getOrPost("/get_group_file_url") {
        val groupId = fetchOrThrow("group_id")
        val id = fetchOrThrow("file_id")
        val busid = fetchOrThrow("busid").toInt()
        call.respondText(GetGroupFileUrl(groupId, id, busid), ContentType.Application.Json)
    }

    route("/res/[a-fA-F0-9]{32}".toRegex()) {
        get {
            val md5 = call.request.document()
            val file = FileUtils.getFile(md5)
            if (!file.exists()) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respondFile(file)
            }
        }
    }
}